package com.tuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="chitietsanpham")
public class ChiTietSanPham {
	
	@Column(name="machitietsanpham")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maChiTietSanPham;
	
	@OneToOne
	@JoinColumn(name="masanpham")
	private SanPham sanPham;
	
	@OneToOne
	@JoinColumn(name="masize")
	private SizeSanPham sizeSanPham;
	
	@OneToOne
	@JoinColumn(name="mamau")
	private MauSanPham mauSanPham;
	
	@Column(name="soluong")
	private int soLuong;
	@Column(name="ngaynhap")
	private String ngayNhap;
	
	public ChiTietSanPham() {
		super();
	}

	public int getMaChiTietSanPham() {
		return maChiTietSanPham;
	}

	public void setMaChiTietSanPham(int maChiTietSanPham) {
		this.maChiTietSanPham = maChiTietSanPham;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public SizeSanPham getSizeSanPham() {
		return sizeSanPham;
	}

	public void setSizeSanPham(SizeSanPham sizeSanPham) {
		this.sizeSanPham = sizeSanPham;
	}

	public MauSanPham getMauSanPham() {
		return mauSanPham;
	}

	public void setMauSanPham(MauSanPham mauSanPham) {
		this.mauSanPham = mauSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	
	
	
}
