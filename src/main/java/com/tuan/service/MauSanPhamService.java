package com.tuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuan.dao.MauSanPhamDAO;
import com.tuan.daoimpl.MauSanPhamImpl;
import com.tuan.entity.MauSanPham;

@Service
public class MauSanPhamService implements MauSanPhamImpl{

	@Autowired
	private MauSanPhamDAO mauSanPhamDAO;

	@Override
	public List<MauSanPham> layDanhSachMauSanPham() {

		return mauSanPhamDAO.layDanhSachMauSanPham();
	}
	
	
}
