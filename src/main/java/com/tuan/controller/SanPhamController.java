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
@RequestMapping("sanpham/")
public class SanPhamController {
	
	@Autowired
	private DanhMucService danhMucService;
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@GetMapping("{madanhmuc}/{tendanhmuc}")
	public String Default(ModelMap modelMap, @PathVariable(name="madanhmuc")int maDanhMuc
			,@PathVariable(name="tendanhmuc")String tenDanhMuc,HttpSession httpSession) {
		List<DanhMucSanPham> listDanhMucSanPham = danhMucService.layTatCaDanhMuc();
		modelMap.addAttribute("listDanhMucSanPham", listDanhMucSanPham);
		modelMap.addAttribute("tenDanhMuc",tenDanhMuc);
		
		List<SanPham> listSanPham=sanPhamService.layDanhSachSanPhamTheoDanhMuc(maDanhMuc);
		modelMap.addAttribute("listSanPham",listSanPham);
		
		if (httpSession.getAttribute("gioHang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("gioHang");
			modelMap.addAttribute("soLuongSanPhamTrongGioHang", listGioHang.size());
		}
		
		if (httpSession.getAttribute("email") != null) {
			String tenDangNhap = (String) httpSession.getAttribute("email");
			String strChuCaiDau = tenDangNhap.substring(0, 1).toUpperCase();
			modelMap.addAttribute("sessionTenDangNhap", strChuCaiDau);
		}
		return "sanpham";
	}
	
}
