package com.tuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuan.dao.NhanVienDAO;
import com.tuan.daoimpl.NhanVienDAOImpl;
import com.tuan.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienDAOImpl {
	@Autowired
	private NhanVienDAO nhanVienDAO;

	@Override
	public boolean kiemTraDangNhap(String email, String matKhau) {
		boolean kiemTra=nhanVienDAO.kiemTraDangNhap(email, matKhau);
		return kiemTra;
	}

	@Override
	public boolean dangKyTaiKhoan(NhanVien nhanVien) {
		boolean kiemTra=nhanVienDAO.dangKyTaiKhoan(nhanVien);
		return kiemTra;
	}
	
	
}
