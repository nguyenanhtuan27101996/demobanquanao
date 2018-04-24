package com.tuan.daoimpl;

import java.util.List;

import com.tuan.entity.DanhMucSanPham;

public interface DanhMucDAOImpl {

	List<DanhMucSanPham> layTatCaDanhMuc();
	
	void themDanhMucSanPham(DanhMucSanPham danhMucSanPham);
	
}
