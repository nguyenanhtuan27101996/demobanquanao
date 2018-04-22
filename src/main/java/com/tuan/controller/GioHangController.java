package com.tuan.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuan.entity.ChiTietHoaDon;
import com.tuan.entity.ChiTietHoaDonId;
import com.tuan.entity.DanhMucSanPham;
import com.tuan.entity.GioHang;
import com.tuan.entity.HoaDon;
import com.tuan.service.ChiTietHoaDonService;
import com.tuan.service.DanhMucService;
import com.tuan.service.HoaDonService;

@Controller
@RequestMapping("giohang/")
public class GioHangController {

	@Autowired
	private HoaDonService hoaDonService;
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@Autowired
	private DanhMucService danhMucService;
	
	@GetMapping
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		if (httpSession.getAttribute("gioHang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("gioHang");
			modelMap.addAttribute("soLuongSanPhamTrongGioHang", listGioHang.size());
			modelMap.addAttribute("listGioHang", listGioHang);
		}
		if (httpSession.getAttribute("email") != null) {
			String tenDangNhap = (String) httpSession.getAttribute("email");
			String strChuCaiDau = tenDangNhap.substring(0, 1).toUpperCase();
			modelMap.addAttribute("sessionTenDangNhap", strChuCaiDau);
		}
		List<DanhMucSanPham> listDanhMucSanPham = danhMucService.layTatCaDanhMuc();
		modelMap.addAttribute("listDanhMucSanPham",listDanhMucSanPham);
		return "giohang";
	}
	
	@PostMapping
	public String themHoaDon(@RequestParam String tenKhachHang, @RequestParam String soDienThoai,
			@RequestParam String diaChiKhachHang, @RequestParam String hinhThucGiaoHang, @RequestParam String ghiChu,
			HttpSession httpSession) {
		
		System.out.println(hinhThucGiaoHang);
		if (httpSession.getAttribute("gioHang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("gioHang");
			
			HoaDon hoaDon=new HoaDon();
			hoaDon.setTenKhachHang(tenKhachHang);
			hoaDon.setSoDienThoai(soDienThoai);
			hoaDon.setDiaChiKhachHang(diaChiKhachHang);
			hoaDon.setHinhThucGiaoHang(hinhThucGiaoHang);
			hoaDon.setGhiChu(ghiChu);
			
			int idHoaDon=hoaDonService.themHoaDon(hoaDon);
			
			if (idHoaDon > 0) {
				for (GioHang gioHang : listGioHang) {
					ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
					chiTietHoaDonId.setMaChiTietSanPham(gioHang.getMaChiTiet());
					chiTietHoaDonId.setMaHoaDon(hoaDon.getMaHoaDon());
					
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
					chiTietHoaDon.setSoLuong(gioHang.getSoLuong());
					chiTietHoaDon.setGiaTien(gioHang.getGiaTien());
					 
					chiTietHoaDonService.themChiTietHoaDon(chiTietHoaDon);
					
				}
			} else {
				System.out.println("them that bai");
			}
			
			
			
			
		}
		
		
		return "giohang";
	}
}
