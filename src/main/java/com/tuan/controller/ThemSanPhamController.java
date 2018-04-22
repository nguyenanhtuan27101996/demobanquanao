package com.tuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuan.entity.DanhMucSanPham;
import com.tuan.entity.MauSanPham;
import com.tuan.entity.SanPham;
import com.tuan.entity.SizeSanPham;
import com.tuan.service.DanhMucService;
import com.tuan.service.MauSanPhamService;
import com.tuan.service.SanPhamService;
import com.tuan.service.SizeSanPhamService;

@Controller
@RequestMapping("themsanpham/")
public class ThemSanPhamController {

	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private DanhMucService danhMucService;
	@Autowired
	private MauSanPhamService mauSanPhamService;
	@Autowired
	private SizeSanPhamService sizeSanPhamService;
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<SanPham> listSanPham=sanPhamService.layDanhSachSanPhamLimit(0, 5);
		modelMap.addAttribute("listSanPham",listSanPham);
		
		List<SanPham> listTatCaSanPham=sanPhamService.layTatCaSanPham();
		int tongSoTrang = (int) Math.ceil((double)listTatCaSanPham.size() / 5);
		
		modelMap.addAttribute("listTatCaSanPham",listTatCaSanPham);
		modelMap.addAttribute("tongSoTrang",tongSoTrang);
		
		List<DanhMucSanPham> listDanhMucSanPham = danhMucService.layTatCaDanhMuc();
		modelMap.addAttribute("listDanhMucSanPham",listDanhMucSanPham);
		
		List<MauSanPham> listMauSanPham = mauSanPhamService.layDanhSachMauSanPham();
		modelMap.addAttribute("listMauSanPham",listMauSanPham);
		
		List<SizeSanPham> listSizeSanPham = sizeSanPhamService.layDanhSachSizeSanPham();
		modelMap.addAttribute("listSizeSanPham",listSizeSanPham);
		return "themsanpham";
	}
}
