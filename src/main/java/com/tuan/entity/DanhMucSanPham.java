package com.tuan.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="danhmucsanpham")
public class DanhMucSanPham {

	@Column(name="madanhmuc")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maDanhMuc;
	
	@Column(name="tendanhmuc")
	private String tenDanhMuc;
	
	@Column(name="hinhdanhmuc")
	private String hinhDanhMuc;

	@OneToMany
	@JoinColumn(name="madanhmuc")
	private Set <SanPham> setSanPham;
	
	public DanhMucSanPham() {
		
	}

	public DanhMucSanPham(int maDanhMuc, String tenDanhMuc, String hinhDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
		this.hinhDanhMuc = hinhDanhMuc;
	}

	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getHinhDanhMuc() {
		return hinhDanhMuc;
	}

	public void setHinhDanhMuc(String hinhDanhMuc) {
		this.hinhDanhMuc = hinhDanhMuc;
	}

	public Set<SanPham> getSetSanPham() {
		return setSanPham;
	}

	public void setSetSanPham(Set<SanPham> setSanPham) {
		this.setSanPham = setSanPham;
	}
	
	
}
