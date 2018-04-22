package com.tuan.daoimpl;

import java.util.List;

import com.tuan.entity.SanPham;

public interface SanPhamDAOImpl {
	List<SanPham> layDanhSachSanPhamLimit(int sanPhamBatDau,int sanPhamCuoi);
	
	SanPham layDanhSachChiTietSanPhamTheoMa(int maSanPham);
	
	List<SanPham> layDanhSachSanPhamTheoDanhMuc(int maDanhMuc);
	
	List<SanPham> layTatCaSanPham();
	
	boolean xoaSanPhamTheoMa(int maSanPham);
	
	boolean themSanPham(SanPham sanPham);
	
	boolean capNhatSanPham(SanPham sanPham);
}
