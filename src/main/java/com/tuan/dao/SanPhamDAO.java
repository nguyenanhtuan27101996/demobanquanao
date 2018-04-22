package com.tuan.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuan.daoimpl.SanPhamDAOImpl;
import com.tuan.entity.ChiTietSanPham;
import com.tuan.entity.SanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<SanPham> layDanhSachSanPhamLimit(int sanPhamBatDau,int sanPhamCuoi) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from sanpham";
		List<SanPham> listSanPham =session.createQuery(sql).setFirstResult(sanPhamBatDau)
				.setMaxResults(sanPhamCuoi).getResultList();
		return listSanPham;
	}

	@Transactional
	@Override
	public SanPham layDanhSachChiTietSanPhamTheoMa(int maSanPham) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from sanpham where masanpham='"+maSanPham+"'";
		SanPham sanPham =(SanPham) session.createQuery(sql).getSingleResult();
		
		
		return sanPham;
	}

	@Transactional
	@Override
	public List<SanPham> layDanhSachSanPhamTheoDanhMuc(int maDanhMuc) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from sanpham where madanhmuc='"+maDanhMuc+"'";
		List<SanPham> listSanPham =session.createQuery(sql).getResultList();
		return listSanPham;
	}

	@Transactional
	@Override
	public List<SanPham> layTatCaSanPham() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from sanpham";
		List<SanPham> listSanPham = session.createQuery(sql).getResultList();
		return listSanPham;
	}

	@Transactional
	@Override
	public boolean xoaSanPhamTheoMa(int maSanPham) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class, maSanPham);
		
		Set<ChiTietSanPham> setChiTietSanPham=sanPham.getSetChiTietSanPham();
		
		for (ChiTietSanPham chiTietSanPham : setChiTietSanPham) {
			session.createQuery("delete chitiethoadon where machitietsanpham='"
		+chiTietSanPham.getMaChiTietSanPham()+"'").executeUpdate();
			
			
		}
		session.createQuery("delete chitietkhuyenmai where masanpham='"
				+maSanPham+"'").executeUpdate();
		session.createQuery("delete chitietsanpham where masanpham='"
				+maSanPham+"'").executeUpdate();
		session.createQuery("delete sanpham where masanpham='"
				+maSanPham+"'").executeUpdate();
		
		return false;
	}

	@Transactional
	@Override
	public boolean themSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(sanPham);
		if(id > 0 ) {
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public boolean capNhatSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		boolean kiemTra = false;
		if(kiemTra == false) {
			session.createQuery("delete chitietsanpham where masanpham='"
					+sanPham.getMaSanPham()+"'").executeUpdate();
			session.update(sanPham);
			kiemTra = true;
		}
		
		return kiemTra;
	}

}
