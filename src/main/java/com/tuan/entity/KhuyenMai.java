package com.tuan.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="khuyenmai")
public class KhuyenMai {
	
	@Column(name="makhuyenmai")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maKhuyenMai;
	
	@Column(name="tenkhuyenmai")
	private String tenKhuyenMai;
	
	@Column(name="thoigianbatdau")
	private String thoiGianBatDau;
	
	@Column(name="thoigianketthuc")
	private String thoiGianKetThuc;
	
	@Column(name="mota")
	private String moTa;
	
	@Column(name="hinhkhuyenmai")
	private String hinhKhuyenMai;
	
	@Column(name="giagiam")
	private int giaGiam;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="chitietkhuyenmai",
	joinColumns= {@JoinColumn(name="makhuyenmai",referencedColumnName="makhuyenmai")},
	inverseJoinColumns= {@JoinColumn(name="masanpham",referencedColumnName="masanpham")})
	private Set <SanPham> setSanPham;
	
	public KhuyenMai() {
		super();
	}

	public int getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(int maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhKhuyenMai() {
		return hinhKhuyenMai;
	}

	public void setHinhKhuyenMai(String hinhKhuyenMai) {
		this.hinhKhuyenMai = hinhKhuyenMai;
	}

	public int getGiaGiam() {
		return giaGiam;
	}

	public void setGiaGiam(int giaGiam) {
		this.giaGiam = giaGiam;
	}

	public Set<SanPham> getSetSanPham() {
		return setSanPham;
	}

	public void setSetSanPham(Set<SanPham> setSanPham) {
		this.setSanPham = setSanPham;
	}
	
	
}
