package com.tuan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuan.daoimpl.MauSanPhamImpl;
import com.tuan.entity.MauSanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class MauSanPhamDAO implements MauSanPhamImpl {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<MauSanPham> layDanhSachMauSanPham() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from mausanpham";
		List<MauSanPham> listMauSanPham = session.createQuery(sql).getResultList();
		return listMauSanPham;
	}
	
	
}
