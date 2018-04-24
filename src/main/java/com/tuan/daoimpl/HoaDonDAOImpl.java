package com.tuan.daoimpl;

import java.util.List;

import com.tuan.entity.HoaDon;

public interface HoaDonDAOImpl {

	int themHoaDon(HoaDon hoaDon);
	
	List<HoaDon> layDanhSachHoaDonLimit(int batDau, int ketThuc);
	
 	List<HoaDon> layDanhSachTatCaHoaDon();
 	
 	boolean capNhatTinhTrangHoaDon(int maHoaDon, int tinhTrang);
}
