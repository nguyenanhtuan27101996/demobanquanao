package com.tuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="sizesanpham")
public class SizeSanPham {

	@Column(name="masize")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maSize;
	
	@Column(name="size")
	private String size;

	public SizeSanPham() {
		super();
	}

	public int getMaSize() {
		return maSize;
	}

	public void setMaSize(int maSize) {
		this.maSize = maSize;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
}
