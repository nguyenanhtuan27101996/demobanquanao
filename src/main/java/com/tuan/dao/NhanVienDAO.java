package com.tuan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuan.daoimpl.NhanVienDAOImpl;
import com.tuan.entity.NhanVien;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public boolean kiemTraDangNhap(String email, String matKhau) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from nhanvien where email='" + email + "'and matkhau='" + matKhau + "'";

		try {
			NhanVien nhanVien = (NhanVien) session.createQuery(sql).getSingleResult();
			if (nhanVien != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}

	}

	@Transactional
	@Override
	public boolean dangKyTaiKhoan(NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		int maNhanVien = (int) session.save(nhanVien);
		if (maNhanVien > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
