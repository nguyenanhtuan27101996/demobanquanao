package com.tuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuan.dao.SanPhamDAO;
import com.tuan.daoimpl.SanPhamDAOImpl;
import com.tuan.entity.SanPham;

@Service
public class SanPhamService implements SanPhamDAOImpl {
	@Autowired
	private SanPhamDAO sanPhamDAO;
	@Override
	public List<SanPham> layDanhSachSanPhamLimit(int sanPhamBatDau,int sanPhamCuoi) {
		List<SanPham> listSanPham = sanPhamDAO.layDanhSachSanPhamLimit(sanPhamBatDau,sanPhamCuoi);
		return listSanPham;
	}
	@Override
	public SanPham layDanhSachChiTietSanPhamTheoMa(int maSanPham) {
		SanPham sanPham = sanPhamDAO.layDanhSachChiTietSanPhamTheoMa(maSanPham);
		return sanPham;
	}
	@Override
	public List<SanPham> layDanhSachSanPhamTheoDanhMuc(int maDanhMuc) {
		
		return sanPhamDAO.layDanhSachSanPhamTheoDanhMuc(maDanhMuc);
	}
	@Override
	public List<SanPham> layTatCaSanPham() {
		
		return sanPhamDAO.layTatCaSanPham();
	}
	@Override
	public boolean xoaSanPhamTheoMa(int maSanPham) {
		
		return sanPhamDAO.xoaSanPhamTheoMa(maSanPham);
	}
	@Override
	public boolean themSanPham(SanPham sanPham) {
		
		return sanPhamDAO.themSanPham(sanPham);
	}
	@Override
	public boolean capNhatSanPham(SanPham sanPham) {
		
		return sanPhamDAO.capNhatSanPham(sanPham);
	}

}
