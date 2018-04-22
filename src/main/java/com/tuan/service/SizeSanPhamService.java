package com.tuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuan.dao.SizeSanPhamDAO;
import com.tuan.daoimpl.SizeSanPhamImpl;
import com.tuan.entity.SizeSanPham;

@Service
public class SizeSanPhamService implements SizeSanPhamImpl{

	@Autowired
	private SizeSanPhamDAO sizeSanPhamDAO;

	@Override
	public List<SizeSanPham> layDanhSachSizeSanPham() {
		
		return sizeSanPhamDAO.layDanhSachSizeSanPham();
	}
	
	
}
