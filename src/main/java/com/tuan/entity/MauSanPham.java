package com.tuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="mausanpham")
public class MauSanPham {

	@Column(name="mamau")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maMau;
	
	@Column(name="tenmau")
	private String tenMau;

	public MauSanPham() {
		super();
	}

	public int getMaMau() {
		return maMau;
	}

	public void setMaMau(int maMau) {
		this.maMau = maMau;
	}

	public String getTenMau() {
		return tenMau;
	}

	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	
	
}
