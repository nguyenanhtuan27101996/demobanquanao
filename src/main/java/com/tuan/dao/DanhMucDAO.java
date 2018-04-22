package com.tuan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuan.daoimpl.DanhMucDAOImpl;
import com.tuan.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucDAOImpl{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<DanhMucSanPham> layTatCaDanhMuc() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from danhmucsanpham";
		List<DanhMucSanPham> listDanhMucSanPham = session.createQuery(sql).getResultList();
		return listDanhMucSanPham;
	}

	
}
