package com.tuan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="nhanvien")
public class NhanVien {
	@Column(name="manhanvien")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maNhanVien;
	
	@Column(name="hoten")
	private String hoTen;
	
	@Column(name="diachi")
	private String diaChi;
	
	@Column(name="gioitinh")
	private boolean gioiTinh;
	
	@Column(name="cmnd")
	private String cmnd;
	
	@Column(name="sdt")
	private String soDienThoai;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="machucvu")
	private ChucVu chucVu;
	
	@Column(name="email")
	private String email;
	
	@Column(name="tendangnhap")
	private String tenDangNhap;
	
	@Column(name="matkhau")
	private String matKhau;

	public NhanVien() {
		
	}
	

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public ChucVu getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	
	
}
