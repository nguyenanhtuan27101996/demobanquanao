package com.tuan.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuan.entity.ChiTietSanPham;
import com.tuan.entity.DanhMucSanPham;
import com.tuan.entity.GioHang;
import com.tuan.entity.HoaDon;
import com.tuan.entity.JSON_SanPham;
import com.tuan.entity.MauSanPham;
import com.tuan.entity.SanPham;
import com.tuan.entity.SizeSanPham;
import com.tuan.service.DanhMucService;
import com.tuan.service.HoaDonService;
import com.tuan.service.NhanVienService;
import com.tuan.service.SanPhamService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"email","gioHang"})
public class ApiController {

	@Autowired
	private NhanVienService nhanVienService;
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@Autowired
	private DanhMucService danhMucService;
	
	@Autowired
	private ServletContext servletContext;
	
	
	@GetMapping("kiemtradangnhap")
	@ResponseBody
	public String xuLyDangNhap(@RequestParam String email,@RequestParam String matKhau,ModelMap modelMap) {
		boolean kiemTra=nhanVienService.kiemTraDangNhap(email,matKhau);
		
		modelMap.addAttribute("email",email);
		
		return ""+kiemTra;
	}
	
	@GetMapping("xoagiohang")
	@ResponseBody
	public String xoaGioHang(HttpSession httpSession, @RequestParam int maSanPham, @RequestParam int maSize,
			@RequestParam int maMau) {
		if (null != httpSession.getAttribute("gioHang")) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("gioHang");
			int viTriSanPham = kiemTraTonTaiGioHang(listGioHang, maSanPham, maSize, maMau);
			listGioHang.remove(viTriSanPham);	

			
		}
		
		
		return "";
	}
	
	
	@GetMapping(path = "capnhatgiohang",produces="text/plain; charset=utf-8")
	@ResponseBody
	public String capNhatGioHang(HttpSession httpSession,@RequestParam int maSanPham,@RequestParam int maSize,
			@RequestParam int maMau,@RequestParam int soLuong) {
		
		if (null != httpSession.getAttribute("gioHang")) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("gioHang");

			int viTriSanPham = kiemTraTonTaiGioHang(listGioHang, maSanPham, maSize, maMau);
			listGioHang.get(viTriSanPham).setSoLuong(soLuong);
				
		}
		
		return "";
	}
	
	@PostMapping(path= "themgiohang", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String themGioHang(@RequestParam int maSanPham,@RequestParam int maSize,@RequestParam int maMau,
			@RequestParam String tenSanPham,@RequestParam String giaTien,@RequestParam String tenMau,
			@RequestParam String size,@RequestParam int soLuong,@RequestParam int maChiTiet,
			ModelMap modelMap,HttpSession httpSession) {
	
		if (httpSession.getAttribute("gioHang") == null) {
			// tao 1 list chua cac doi tuong gioHang
			List<GioHang> listGioHang = new ArrayList<>();
			// tao doi tuong gioHang
			GioHang gioHang = taoDoiTuongGioHang(maSanPham, maSize, maMau, tenSanPham, giaTien, tenMau, size,maChiTiet);
			listGioHang.add(gioHang);
			//dua listGioHang vao session
			httpSession.setAttribute("gioHang", listGioHang);
		}else {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("gioHang");
			
			int viTriCuaSanPhamChoVaoGioHang = kiemTraTonTaiGioHang(listGioHang, maSanPham, maSize, maMau);
			
			if(viTriCuaSanPhamChoVaoGioHang == -1) {
				// tao doi tuong gioHang
				GioHang gioHang = taoDoiTuongGioHang(maSanPham, maSize, maMau, tenSanPham, giaTien, tenMau, size,maChiTiet);
				listGioHang.add(gioHang);
			}else {
				int soLuongMoiCuaSanPham = listGioHang.get(viTriCuaSanPhamChoVaoGioHang).getSoLuong() + 1;
				// them so luong cua san pham trong gio hang len 1 don vi
				listGioHang.get(viTriCuaSanPhamChoVaoGioHang).setSoLuong(soLuongMoiCuaSanPham);
				
			}	
		}
		
		List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("gioHang");
		for(GioHang gh: listGioHang) {
			System.out.println(gh.getMaSanPham() + " - "+gh.getMaMau() + " - "+gh.getMaSize());
		}
		return ""+listGioHang.size();
	}
	private GioHang taoDoiTuongGioHang(int maSanPham,int maSize,int maMau,String tenSanPham,
			String giaTien,String tenMau,String size,int maChiTiet) {
		GioHang gioHang=new GioHang();
		gioHang.setMaSanPham(maSanPham);
		gioHang.setMaSize(maSize);
		gioHang.setMaMau(maMau);
		gioHang.setTenSanPham(tenSanPham);
		gioHang.setGiaTien(giaTien);
		gioHang.setTenMau(tenMau);
		gioHang.setSize(size);
		gioHang.setSoLuong(1);
		gioHang.setMaChiTiet(maChiTiet);
		return gioHang;
	}
	private int kiemTraTonTaiGioHang(List<GioHang> listGioHang,int maSanPham,int maSize,int maMau) {
		for (int i = 0; i < listGioHang.size(); i++) {
			// neu trong listGioHang da co maSanPham,maSize,maMau trung voi thong tin nguoi dung click vao
			//thi tra ve vitri hien tai cua sanpham do
			if (listGioHang.get(i).getMaSanPham() == maSanPham && listGioHang.get(i).getMaSize() == maSize
					&& listGioHang.get(i).getMaMau() == maMau) {
				return i;
			}
			
		}
		// neu khong trung tra ve -1 de thuc hien add sanpham vao listGioHang
		return -1;
		
	}
	
	
	@GetMapping(path="phantrangsanpham",produces="text/plain; charset=utf-8")
	@ResponseBody
	public String phanTrangSanPham(@RequestParam int sanPhamBatDau) {
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamLimit(sanPhamBatDau, 5);
		String html ="";

		for (SanPham sanPham : listSanPham) {
			html += "<tr>";
			html += "<td>" + sanPham.getTenSanPham() + "</td>";
			html += "<td>" + sanPham.getGiaTien() + "</td>";
			html += "<td>" + sanPham.getGianhCho() + "</td>";
			html += "<td><div class='checkbox'><label><input type='checkbox' value='"+sanPham.getMaSanPham()+"' class='checkboxsanpham'></label></div></td>";
			html += "<td><button class='btn btn-success btn-capnhatsanpham' data-id='"+sanPham.getMaSanPham()+"'>Sửa</button></td>";
			html += "</tr>";
			
		}
		
		return html;
	}
	
	@GetMapping("xoasanpham")
	@ResponseBody
	public String xoaSanPhamTheoMa(@RequestParam int maSanPham) {
		sanPhamService.xoaSanPhamTheoMa(maSanPham);
		return "";
	}
	
	@PostMapping("uploadhinhanh")
	@ResponseBody
	public String uploadHinhAnh(MultipartHttpServletRequest request) {
		
		//lay ra ten cua cac file upload
		Iterator<String> listName = request.getFileNames();
		
		//lay ra file duoc upload
		MultipartFile multipartFile = request.getFile(listName.next());
		
		
		//luu file 
		String pathToSave = servletContext.getRealPath("/resources/img/sanpham/");
		
		File file = new File(pathToSave +"/"+ multipartFile.getOriginalFilename());
		
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	@PostMapping("themsanpham")
	@ResponseBody
	public void themSanPham(@RequestParam String jsonSanPham) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			JsonNode jsonObject = objectMapper.readTree(jsonSanPham);
			
			JsonNode jsonArrayChiTiet = jsonObject.get("chitietsanpham");
			SanPham sanPham = new SanPham();
			
			//gan gia tri cho object danhMucSanPham tu json
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			danhMucSanPham.setMaDanhMuc(jsonObject.get("danhmuc").asInt());
			
			
			Set<ChiTietSanPham> setChiTietSanPham = new HashSet<>();
			
			for (JsonNode jsonObjectChiTiet : jsonArrayChiTiet) {
				//lay ra mamausanpham tu json roi gan cho object mauSanPham
				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMaMau(jsonObjectChiTiet.get("mausanpham").asInt());
				
				//lay ra masizesanpham tu json roi gan cho object sizeSanPham
				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setMaSize(jsonObjectChiTiet.get("sizesanpham").asInt());
				
				//gan cac thuoc tinh cho object chiTietSanPham
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				chiTietSanPham.setMauSanPham(mauSanPham);
				chiTietSanPham.setSizeSanPham(sizeSanPham);
				chiTietSanPham.setSoLuong(jsonObjectChiTiet.get("soluong").asInt());
				chiTietSanPham.setNgayNhap(layNgayThangHienTai());
				//add object chitietsanpham vao set
				
				
				setChiTietSanPham.add(chiTietSanPham);
			}
			
			//gan cac gia tri cho object sanPham
			sanPham.setSetChiTietSanPham(setChiTietSanPham);
			sanPham.setDanhMucSanPham(danhMucSanPham);
			sanPham.setTenSanPham(jsonObject.get("tensanpham").asText());
			sanPham.setGiaTien(jsonObject.get("giatien").asText());
			sanPham.setGianhCho(jsonObject.get("gianhcho").asText());
			sanPham.setMoTa(jsonObject.get("mota").asText());
			sanPham.setHinhSanPham(jsonObject.get("hinhanh").asText());
			
			sanPhamService.themSanPham(sanPham);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@GetMapping(path = "laysanphamtheomasanpham", produces="application/json; charset=utf-8")
	@ResponseBody
	public JSON_SanPham laySanPhamTheoMaSanPham(@RequestParam int maSanPham) {
		SanPham sanPham = sanPhamService.layDanhSachChiTietSanPhamTheoMa(maSanPham);
		JSON_SanPham jsonSanPham = new JSON_SanPham();
		
		jsonSanPham.setMaSanPham(sanPham.getMaSanPham());
		jsonSanPham.setTenSanPham(sanPham.getTenSanPham());
		jsonSanPham.setGiaTien(sanPham.getGiaTien());
		jsonSanPham.setMoTa(sanPham.getMoTa());
		jsonSanPham.setHinhSanPham(sanPham.getHinhSanPham());
		jsonSanPham.setGianhCho(sanPham.getGianhCho());
		
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
		danhMucSanPham.setMaDanhMuc(sanPham.getDanhMucSanPham().getMaDanhMuc());
		danhMucSanPham.setTenDanhMuc(sanPham.getDanhMucSanPham().getTenDanhMuc());
		
		Set<ChiTietSanPham> setChiTietSanPham = new HashSet<>();
		//lay du lieu tu setChiTietSanPham lay duoc tu ajax set cho setChiTietSanPham duoc  tao moi
		for(ChiTietSanPham element : sanPham.getSetChiTietSanPham()) {
			
			//tao 1 doi tuong chitietsanpham moi
			ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
			
			// gan gia tri cho machitietsanpham
			chiTietSanPham.setMaChiTietSanPham(element.getMaChiTietSanPham());
			
			// gan gia tri cho mausanpham
			MauSanPham mauSanPham = new MauSanPham();
			mauSanPham.setMaMau(element.getMauSanPham().getMaMau());
			mauSanPham.setTenMau(element.getMauSanPham().getTenMau());
			
			chiTietSanPham.setMauSanPham(mauSanPham);
			//
			
			// gan gia tri cho sizesanpham
			SizeSanPham sizeSanPham = new SizeSanPham();
			sizeSanPham.setMaSize(element.getSizeSanPham().getMaSize());
			sizeSanPham.setSize(element.getSizeSanPham().getSize());
			
			chiTietSanPham.setSizeSanPham(sizeSanPham);
			//
			
			chiTietSanPham.setSoLuong(element.getSoLuong());
			setChiTietSanPham.add(chiTietSanPham);
			
		}
		
		jsonSanPham.setSetChiTietSanPham(setChiTietSanPham);
		jsonSanPham.setDanhMucSanPham(danhMucSanPham);
		
		
		return jsonSanPham;
	}
	
	@PostMapping(path = "capnhatsanpham",produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String capNhatSanPham(@RequestParam String jsonSanPham) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		boolean kiemTra = false;
		try {
			JsonNode jsonObject = objectMapper.readTree(jsonSanPham);
			
			JsonNode jsonArrayChiTiet = jsonObject.get("chitietsanpham");
			SanPham sanPham = new SanPham();
			
			//gan gia tri cho object danhMucSanPham tu json
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			danhMucSanPham.setMaDanhMuc(jsonObject.get("danhmuc").asInt());
			
			
			Set<ChiTietSanPham> setChiTietSanPham = new HashSet<>();
			
			for (JsonNode jsonObjectChiTiet : jsonArrayChiTiet) {
				//lay ra mamausanpham tu json roi gan cho object mauSanPham
				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMaMau(jsonObjectChiTiet.get("mausanpham").asInt());
				
				//lay ra masizesanpham tu json roi gan cho object sizeSanPham
				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setMaSize(jsonObjectChiTiet.get("sizesanpham").asInt());
				
				//gan cac thuoc tinh cho object chiTietSanPham
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				chiTietSanPham.setMauSanPham(mauSanPham);
				chiTietSanPham.setSizeSanPham(sizeSanPham);
				chiTietSanPham.setSoLuong(jsonObjectChiTiet.get("soluong").asInt());
				chiTietSanPham.setNgayNhap(layNgayThangHienTai());
				//add object chitietsanpham vao set
				
				
				setChiTietSanPham.add(chiTietSanPham);
			}
			
			//gan cac gia tri cho object sanPham
			sanPham.setSetChiTietSanPham(setChiTietSanPham);
			sanPham.setDanhMucSanPham(danhMucSanPham);
			sanPham.setMaSanPham(jsonObject.get("masanpham").asInt());
			sanPham.setTenSanPham(jsonObject.get("tensanpham").asText());
			sanPham.setGiaTien(jsonObject.get("giatien").asText());
			sanPham.setGianhCho(jsonObject.get("gianhcho").asText());
			sanPham.setMoTa(jsonObject.get("mota").asText());
			sanPham.setHinhSanPham(jsonObject.get("hinhanh").asText());
			
			kiemTra = sanPhamService.capNhatSanPham(sanPham);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return ""+kiemTra;
		
	}
	
	@PostMapping(path = "capnhattinhtranghoadon",produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String capNhatTinhTrangHoaDon(@RequestParam int maHoaDon, @RequestParam int tinhTrang) {
		boolean kiemTra = hoaDonService.capNhatTinhTrangHoaDon(maHoaDon, tinhTrang);
		return ""+kiemTra;
	}
	
	@GetMapping(path="phantranghoadon",produces="text/plain; charset=utf-8")
	@ResponseBody
	public String phanTrangHoaDon(@RequestParam int sanPhamBatDau) {
		List<HoaDon> listHoaDon = hoaDonService.layDanhSachHoaDonLimit(sanPhamBatDau, 5);
		String html ="";
		
		for (HoaDon hoaDon : listHoaDon) {
			html += "<tr>";
			html += "<td>" + hoaDon.getTenKhachHang() + "</td>";
			html += "<td>" + hoaDon.getSoDienThoai() + "</td>";
			html += "<td>" + hoaDon.getDiaChiKhachHang() + "</td>";
			
			html += "<td>";
			html += "<select class='form-control' id='tinhtrang' name='tinhtrang' class='tinhtrang'>";
			if(hoaDon.getTinhTrang() == false) {
				html += "<option value='0' selected='selected'>Chưa giao</option>";
				html += "<option value='1'>Đã giao</option>";
			}else {
				html += "<option value='0'>Chưa giao</option>";
				html += "<option value='1' selected='selected'>Đã giao</option>";
			}
			
			html += "</select>";
			html += "</td>";
			
			html += "<td>" + hoaDon.getNgayLap() + "</td>";
			html += "<td>" + hoaDon.getHinhThucGiaoHang() + "</td>";
			html += "<td>" + hoaDon.getGhiChu() + "</td>";
			html += "<td><a href='/demo/chitiethoadon/"+hoaDon.getMaHoaDon()+"'>Chi tiết</a></td>";
			html += "<td><button class='btn btn-success btn-suahoadon' data-mahoadon='"+hoaDon.getMaHoaDon()+"'>Sửa</button></td>";
			html += "</tr>";
			
		}
		
		return html;
	}
	
	@PostMapping(path = "themdanhmuc", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String themDanhMuc(@RequestParam String tenDanhMuc) {
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
		danhMucSanPham.setTenDanhMuc(tenDanhMuc);
		danhMucService.themDanhMucSanPham(danhMucSanPham);
		return "";
	}
	public String layNgayThangHienTai() {
		String ngayHienTai = "";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = new Date();
	    ngayHienTai = dateFormat.format(date);
	     
		return ngayHienTai;
	}
	
	
	
}

