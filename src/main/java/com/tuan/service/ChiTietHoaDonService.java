package com.tuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuan.dao.ChiTietHoaDonDAO;
import com.tuan.daoimpl.ChiTietHoaDonImpl;
import com.tuan.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImpl{

	@Autowired
	private ChiTietHoaDonDAO chiTietHoaDonDAO;
	
	@Override
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		
		return chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon);
	}

}
