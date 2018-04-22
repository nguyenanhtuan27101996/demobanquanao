package com.tuan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuan.entity.DanhMucSanPham;
import com.tuan.entity.GioHang;
import com.tuan.entity.SanPham;
import com.tuan.service.DanhMucService;
import com.tuan.service.SanPhamService;

@Controller
@RequestMapping("chitiet/")
public class ChiTietController {

	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private DanhMucService danhMucService;
	
	@GetMapping("{masanpham}")
	public String Default(@PathVariable int masanpham,ModelMap modelMap,HttpSession httpSession) {
		SanPham sanPham = sanPhamService.layDanhSachChiTietSanPhamTheoMa(masanpham);
		modelMap.addAttribute("sanPham", sanPham);

		List<DanhMucSanPham> listDanhMucSanPham = danhMucService.layTatCaDanhMuc();
		modelMap.addAttribute("listDanhMucSanPham",listDanhMucSanPham);
		
		if (httpSession.getAttribute("gioHang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("gioHang");
			modelMap.addAttribute("soLuongSanPhamTrongGioHang",listGioHang.size());
		}
		if (httpSession.getAttribute("email") != null) {
			String tenDangNhap = (String) httpSession.getAttribute("email");
			String strChuCaiDau = tenDangNhap.substring(0, 1).toUpperCase();
			modelMap.addAttribute("sessionTenDangNhap", strChuCaiDau);
		}
		return "chitiet";
	}
}
