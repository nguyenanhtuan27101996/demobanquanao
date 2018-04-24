package com.tuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuan.entity.ChiTietHoaDon;
import com.tuan.service.ChiTietHoaDonService;

@Controller
@RequestMapping("chitiethoadon/")
public class ChiTietHoaDonController {

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@GetMapping("{maHoaDon}")
	public String Default(@PathVariable int maHoaDon,ModelMap modelMap) {
		List<ChiTietHoaDon> listChiTietHoaDon = chiTietHoaDonService.layChiTietHoaDonTheoMaHoaDon(maHoaDon);
		modelMap.addAttribute("listChiTietHoaDon",listChiTietHoaDon);
		
		return "chitiethoadon";
	}
}
