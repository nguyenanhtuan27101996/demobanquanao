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

@Entity(name="hoadon")
public class HoaDon {
	
	@Column(name="mahoadon")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maHoaDon;
	
	@Column(name="tenkhachhang")
	private String tenKhachHang;
	
	@Column(name="sdt")
	private String soDienThoai;
	
	@Column(name="diachikhachhang")
	private String diaChiKhachHang;
	
	@Column(name="tinhtrang")
	private boolean tinhTrang;
	
	@Column(name="ngaylap")
	private String ngayLap;
	
	@Column(name="hinhthucgiaohang")
	private String hinhThucGiaoHang;
	
	@Column(name="ghichu")
	private String ghiChu;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="mahoadon")
	private Set <ChiTietHoaDon> setChiTietHoaDon;

	public HoaDon() {
		super();
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChiKhachHang() {
		return diaChiKhachHang;
	}

	public void setDiaChiKhachHang(String diaChiKhachHang) {
		this.diaChiKhachHang = diaChiKhachHang;
	}

	public boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Set<ChiTietHoaDon> getSetChiTietHoaDon() {
		return setChiTietHoaDon;
	}

	public void setSetChiTietHoaDon(Set<ChiTietHoaDon> setChiTietHoaDon) {
		this.setChiTietHoaDon = setChiTietHoaDon;
	}

	public String getHinhThucGiaoHang() {
		return hinhThucGiaoHang;
	}

	public void setHinhThucGiaoHang(String hinhThucGiaoHang) {
		this.hinhThucGiaoHang = hinhThucGiaoHang;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
	
}
