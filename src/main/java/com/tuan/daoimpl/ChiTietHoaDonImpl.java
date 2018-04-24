package com.tuan.daoimpl;

import java.util.List;

import com.tuan.entity.ChiTietHoaDon;

public interface ChiTietHoaDonImpl {

	boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
	
	List<ChiTietHoaDon> layChiTietHoaDonTheoMaHoaDon(int maHoaDon);
}
