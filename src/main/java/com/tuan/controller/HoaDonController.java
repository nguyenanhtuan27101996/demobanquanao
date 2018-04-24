package com.tuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuan.entity.ChiTietHoaDon;
import com.tuan.entity.HoaDon;
import com.tuan.service.HoaDonService;

@Controller
@RequestMapping("hoadon/")
public class HoaDonController {

	@Autowired
	private HoaDonService hoaDonService;
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<HoaDon> listHoaDon = hoaDonService.layDanhSachTatCaHoaDon();
		List<HoaDon> listHoaDonLimit = hoaDonService.layDanhSachHoaDonLimit(0, 5);
		
		int tongSoTrang = (int) Math.ceil((double)listHoaDon.size() /5);
		modelMap.addAttribute("listHoaDon",listHoaDon);
		modelMap.addAttribute("listHoaDonLimit",listHoaDonLimit);
		modelMap.addAttribute("tongSoTrang",tongSoTrang);
		
		
		return "hoadon";
	}
}
