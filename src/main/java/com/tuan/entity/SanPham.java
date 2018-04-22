package com.tuan.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="sanpham")
public class SanPham {
	
	@Column(name="masanpham")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maSanPham;
	
	@OneToOne
	@JoinColumn(name="madanhmuc")
	private DanhMucSanPham danhMucSanPham;
	
	
	@Column(name="tensanpham")
	private String tenSanPham;
	
	@Column(name="giatien")
	private String giaTien;
	
	@Column(name="mota")
	private String moTa;
	
	@Column(name="hinhsanpham")
	private String hinhSanPham;
	
	@Column(name="gianhcho")
	private String gianhCho;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="masanpham")
	private Set <ChiTietSanPham> setChiTietSanPham;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="chitietkhuyenmai",
	joinColumns= {@JoinColumn(name="masanpham",referencedColumnName="masanpham")},
	inverseJoinColumns= {@JoinColumn(name="makhuyenmai",referencedColumnName="makhuyenmai")})
	private Set <KhuyenMai> setKhuyenMai;
	
	public SanPham() {
		
	}
	
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

	public String getGianhCho() {
		return gianhCho;
	}

	public void setGianhCho(String gianhCho) {
		this.gianhCho = gianhCho;
	}
	
	
	
}
