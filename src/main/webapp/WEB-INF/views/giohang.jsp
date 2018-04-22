<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div id="header-chitiet" class="container-fluid">
		<nav class="navbar navbar-default none-nav">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href='<c:url value="/"></c:url>'><img
					src='<c:url value='/resources/img/icon_yame_shop.png'></c:url>' /></a>
			</div>
			<ul class="nav navbar-nav navbar-center">
				<li class="active"><a href="#">TRANG CHỦ</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">SẢN PHẨM <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach var="danhMucSanPham" items="${listDanhMucSanPham}">
							<li><a href='<c:url value='/sanpham/${danhMucSanPham.getMaDanhMuc() }/${danhMucSanPham.getTenDanhMuc() }'></c:url>'>
							${danhMucSanPham.getTenDanhMuc() }</a></li>	
							<li role="seperator" class="divider"></li>
						</c:forEach>
					</ul></li>
				<li><a href="#">DỊCH VỤ</a></li>
				<li><a href="#">LIÊN HỆ</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${sessionTenDangNhap!=null }">
						<li><a href=<c:url value="/dangnhap/"></c:url>' class="circle-avatar"><span>${sessionTenDangNhap }</span></a></li>
					</c:when>
					<c:otherwise>
						<li><a href='<c:url value="/dangnhap/"></c:url>'>ĐĂNG NHẬP</a></li>
					</c:otherwise>
				</c:choose>
				<li id="cart-shopping"><a href="#"><img src='<c:url value="/resources/img/icon_shopping_cart.png"></c:url>' />
					<c:if test="${soLuongSanPhamTrongGioHang > 0}">
						<div class="circle-shopping-cart"><span id="soLuongSpGioHang" style="display: inline-block;">${soLuongSanPhamTrongGioHang }</span></div>
						
					</c:if>
					<c:if test="${soLuongSanPhamTrongGioHang == null || soLuongSanPhamTrongGioHang <= 0 }">
						<div><span id="soLuongSpGioHang" style="display: inline-block;">${soLuongSanPhamTrongGioHang }</span></div>
						
					</c:if>
					</a></li>
			</ul>
		</div>
		</nav>
		
	</div>
	
	<div class="container" style="margin-top: 25px;">
		<div class="row">
			<div class="col-md-6 col-sm-12">
				<h3>Danh sách sản phẩm trong giỏ hàng</h3>
				<table class="table">
					<thead>
						<tr>
							<td><h5>Tên sản phẩm</h5></td>
							<td><h5>Màu sắc</h5></td>
							<td><h5>Size</h5></td>
							<td><h5>Số lượng</h5></td>
							<td><h5>Giá tiền</h5></td>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${listGioHang }">
							<tr data-machitiet="${item.getMaChiTiet() }">
								<td class="tensanpham-giohang" data-masanpham-giohang="${item.getMaSanPham() }">${item.getTenSanPham() }</td>
								<td class="mausanpham-giohang" data-mamau-giohang="${item.getMaMau() }">${item.getTenMau() }</td>
								<td class="size-giohang" data-masize-giohang="${item.getMaSize() }">${item.getSize() }</td>
								<td class="soluong"><input type="number"
									value="${item.getSoLuong() }" class="soluong-giohang" min="1" /></td>
								<td class="giatien" data-giatiengh="${item.getGiaTien() }">${item.getGiaTien() }</td>
								<td class="btn btn-danger btn-xoagiohang">Xóa</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<h3>Tổng tiền : <span style="color:red;" id="tongTien">0 VNĐ</span></h3>
			</div>
			<div class="col-md-6 col-sm-12">
				<h3>Thông tin người mua hàng</h3>
				<div class="form-group">
					<form action="" method="post">
						<label for="tennguoimua">Tên người mua</label> 
						<input id="tennguoimua" type="text" class="form-control" name="tenKhachHang" /><br>
						
						<label for="dienthoailienlac">Số điện thoại liên lạc</label> 
						<input id="dienthoailienlac" type="text" class="form-control" name="soDienThoai" />
	
						<div class="radio">
							<label><input type="radio" name="hinhThucGiaoHang" checked="checked" value="Giao hàng tận nơi">Giao hàng tận nơi</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="hinhThucGiaoHang" value="Nhận hàng tại cửa hàng">Nhận hàng tại cửa hàng</label>
						</div>
						
						<label for="diachinhanhang">Địa chỉ nhận hàng</label> 
						<input id="diachinhanhang" type="text" class="form-control" name="diaChiKhachHang" /><br>
						
						<label for="ghichu">Ghi chú</label>
						<textarea class="form-control" rows="5" id="ghichu" name="ghiChu"></textarea><br>
						
						<input type="submit" class="btn btn-success" value="Đặt hàng">
					</form>
				</div>
			</div>
		</div>

		
			
			
			
		
	</div>
	
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4">
				<p class="text-center">
					<span class="title-footer">THÔNG TIN SHOP</span>
				</p>
				<span>Yame là một thương hiệu thời trang đầy uy tín, luôn đảm
					bảo chất lượng sản phẩm tốt nhất cho khách hàng</span>

			</div>
			<div class="col-sm-4 col-md-4">
				<p class="text-center">
					<span class="title-footer">LIÊN HỆ</span>
				</p>
				<span>262 Thụy Khuê, quận Tây Hồ, Hà Nội</span> <span>nguyenanhtuan27101996@gmail.com</span>
				<span>01636218566</span>
			</div>
			<div class="col-sm-4 col-md-4">
				<p class="text-center">
					<span class="title-footer">GÓP Ý</span>
				</p>
				<form method="post">
					<input class="input-footer" style="height: 38px;" type="text"
						placeholder="Email" name="tenNhanVien">
					<textarea class="input-footer" rows="4" cols="30"
						placeholder="Nội dung" name="tuoi"></textarea>
					<input type="submit" class="material-primary-button" value="ĐỒNG Ý">
				</form>

			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>