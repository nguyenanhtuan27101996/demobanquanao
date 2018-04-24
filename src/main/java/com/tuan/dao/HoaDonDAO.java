package com.tuan.dao;

import java.util.List;

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
	@Transactional
	@Override
	public List<HoaDon> layDanhSachHoaDonLimit(int batDau, int ketThuc) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from hoadon";
		List<HoaDon> listHoaDonLimit = session.createQuery(sql).setFirstResult(batDau)
				.setMaxResults(ketThuc).getResultList();
		
		return listHoaDonLimit;
	}

	@Transactional
	@Override
	public List<HoaDon> layDanhSachTatCaHoaDon() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from hoadon";
		List<HoaDon> listHoaDon = session.createQuery(sql).getResultList();
		
		return listHoaDon;
	}
	
	@Transactional
	@Override
	public boolean capNhatTinhTrangHoaDon(int maHoaDon, int tinhTrang) {
		String sql = "update from hoadon set tinhtrang ="+tinhTrang+" where mahoadon='"+maHoaDon+"'";
		Session session = sessionFactory.getCurrentSession();
		int id  = session.createQuery(sql).executeUpdate();
		if(id > 0 ) {
			return true;
		}
		return false;
	}
}
