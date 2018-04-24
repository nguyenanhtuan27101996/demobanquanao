package com.tuan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuan.daoimpl.ChiTietHoaDonImpl;
import com.tuan.entity.ChiTietHoaDon;
import com.tuan.entity.ChiTietHoaDonId;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChiTietHoaDonImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session=sessionFactory.getCurrentSession();
		
		ChiTietHoaDonId chiTietHoaDonId=(ChiTietHoaDonId) session.save(chiTietHoaDon);
		
		if(chiTietHoaDonId != null) {
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public List<ChiTietHoaDon> layChiTietHoaDonTheoMaHoaDon(int maHoaDon) {
		Session session=sessionFactory.getCurrentSession();
		String sql ="from chitiethoadon where mahoadon='"+maHoaDon+"'";
		List<ChiTietHoaDon> listChiTietHoaDon = session.createQuery(sql).getResultList();
		return listChiTietHoaDon;
	}

}
