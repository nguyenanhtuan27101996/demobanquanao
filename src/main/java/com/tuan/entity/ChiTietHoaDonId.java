package com.tuan.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonId implements Serializable{

	private int maHoaDon;
	private int maChiTietSanPham;

	public ChiTietHoaDonId() {
		super();
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getMaChiTietSanPham() {
		return maChiTietSanPham;
	}

	public void setMaChiTietSanPham(int maChiTietSanPham) {
		this.maChiTietSanPham = maChiTietSanPham;
	}
}
