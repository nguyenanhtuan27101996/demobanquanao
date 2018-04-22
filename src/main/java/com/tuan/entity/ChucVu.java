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

@Entity(name="chucvu")
public class ChucVu {
	
	@Column(name="machucvu")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maChucVu;
	
	@Column(name="tenchucvu")
	private String tenChucVu;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="machucvu")
	private Set <NhanVien> setNhanVien;
	
	public ChucVu() {
		
	}

	public ChucVu(int maChucVu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}

	public int getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public Set<NhanVien> getSetNhanVien() {
		return setNhanVien;
	}

	public void setSetNhanVien(Set<NhanVien> setNhanVien) {
		this.setNhanVien = setNhanVien;
	}
	
	
	
}
