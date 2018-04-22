package com.tuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tuan.dao.HoaDonDAO;
import com.tuan.daoimpl.HoaDonDAOImpl;
import com.tuan.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonDAOImpl{

	@Autowired
	private HoaDonDAO hoaDonDAO;
	
	
	@Override
	public int themHoaDon(HoaDon hoaDon) {
		int id = hoaDonDAO.themHoaDon(hoaDon);
		return id;
	}

}
