package com.tuan.entity;

import java.util.Set;

public class JSON_SanPham {
	private int maSanPham;
	private DanhMucSanPham danhMucSanPham;
	private String tenSanPham;
	private String giaTien;
	private String moTa;
	private String hinhSanPham;
	private String gianhCho;
	private Set <ChiTietSanPham> setChiTietSanPham;
	private Set <KhuyenMai> setKhuyenMai;
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public DanhMucSanPham getDanhMucSanPham() {
		return danhMucSanPham;
	}
	public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhSanPham() {
		return hinhSanPham;
	}
	public void setHinhSanPham(String hinhSanPham) {
		this.hinhSanPham = hinhSanPham;
	}
	public String getGianhCho() {
		return gianhCho;
	}
	public void setGianhCho(String gianhCho) {
		this.gianhCho = gianhCho;
	}
	public Set<ChiTietSanPham> getSetChiTietSanPham() {
		return setChiTietSanPham;
	}
	public void setSetChiTietSanPham(Set<ChiTietSanPham> setChiTietSanPham) {
		this.setChiTietSanPham = setChiTietSanPham;
	}
	public Set<KhuyenMai> getSetKhuyenMai() {
		return setKhuyenMai;
	}
	public void setSetKhuyenMai(Set<KhuyenMai> setKhuyenMai) {
		this.setKhuyenMai = setKhuyenMai;
	}
	
	
}
