package com.tuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuan.entity.DanhMucSanPham;
import com.tuan.service.DanhMucService;

@Controller
@RequestMapping("danhmucsanpham/")
public class DanhMucController {

	@Autowired
	private DanhMucService danhMucService;
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<DanhMucSanPham> listDanhMucSanPham = danhMucService.layTatCaDanhMuc();
		modelMap.addAttribute("listDanhMucSanPham",listDanhMucSanPham);
		return "danhmucsanpham";
	}
	
}
