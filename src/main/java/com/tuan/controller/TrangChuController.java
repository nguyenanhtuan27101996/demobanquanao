package com.tuan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuan.entity.DanhMucSanPham;
import com.tuan.entity.GioHang;
import com.tuan.entity.SanPham;
import com.tuan.service.DanhMucService;
import com.tuan.service.SanPhamService;

@Controller
@RequestMapping("/")
public class TrangChuController {
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private DanhMucService danhMucService;
	
	@GetMapping
	public String Default(HttpSession httpSession,ModelMap modelMap	) {
		
		List<DanhMucSanPham> listDanhMucSanPham = danhMucService.layTatCaDanhMuc();
		modelMap.addAttribute("listDanhMucSanPham",listDanhMucSanPham);
		
		if (httpSession.getAttribute("email") != null) {
			String tenDangNhap = (String) httpSession.getAttribute("email");
			String strChuCaiDau = tenDangNhap.substring(0, 1).toUpperCase();
			modelMap.addAttribute("sessionTenDangNhap", strChuCaiDau);
		}
		if (httpSession.getAttribute("gioHang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("gioHang");
			modelMap.addAttribute("soLuongSanPhamTrongGioHang", listGioHang.size());
		}
		
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamLimit(0,20);
		modelMap.addAttribute("listSanPham",listSanPham);
		
		return "trangchu";
	}
	
	@PostMapping
	@Transactional
	public String themNhanVien(@RequestParam String tenNhanVien,@RequestParam int tuoi){
		
		
		return "trangchu";
	}
}
