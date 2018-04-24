package com.tuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuan.dao.DanhMucDAO;
import com.tuan.daoimpl.DanhMucDAOImpl;
import com.tuan.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucDAOImpl{

	@Autowired
	private DanhMucDAO danhMucDAO;

	@Override
	public List<DanhMucSanPham> layTatCaDanhMuc() {
		List<DanhMucSanPham> listDanhMucSanPham = danhMucDAO.layTatCaDanhMuc();
		return listDanhMucSanPham;
	}

	@Override
	public void themDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		danhMucDAO.themDanhMucSanPham(danhMucSanPham);		
	}
	
	
}
