package com.tuan.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "chitiethoadon")
public class ChiTietHoaDon {
	
	@EmbeddedId
	private ChiTietHoaDonId chiTietHoaDonId;

	@Column(name = "soluong")
	private int soLuong;

	@Column(name = "giatien")
	private String giaTien;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDonId getChiTietHoaDonId() {
		return chiTietHoaDonId;
	}

	public void setChiTietHoaDonId(ChiTietHoaDonId chiTietHoaDonId) {
		this.chiTietHoaDonId = chiTietHoaDonId;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}

}

