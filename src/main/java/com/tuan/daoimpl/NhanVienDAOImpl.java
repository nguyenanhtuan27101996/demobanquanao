package com.tuan.daoimpl;

import org.springframework.stereotype.Repository;

import com.tuan.entity.NhanVien;

@Repository
public interface NhanVienDAOImpl {
	boolean kiemTraDangNhap(String email,String matKhau);
	
	boolean dangKyTaiKhoan(NhanVien nhanVien);
}
