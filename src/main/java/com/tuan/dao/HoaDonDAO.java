package com.tuan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuan.daoimpl.HoaDonDAOImpl;
import com.tuan.entity.HoaDon;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public int themHoaDon(HoaDon hoaDon) {
		Session session = sessionFactory.getCurrentSession();
		
		//neu them thanh cong thi lay ra id
		int id = (int) session.save(hoaDon);
		
		if(id > 0) {
			return id;
		}else {
			return 0;
		}
		
	}
}
