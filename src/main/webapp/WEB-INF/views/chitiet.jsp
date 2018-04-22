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
						<li><a href='<c:url value="/dangnhap/"></c:url>' class="circle-avatar"><span>${sessionTenDangNhap }</span></a></li>
					</c:when>
					<c:otherwise>
						<li><a href='<c:url value="/dangnhap/"></c:url>'>ĐĂNG NHẬP</a></li>
					</c:otherwise>
				</c:choose>
				<li id="cart-shopping"><a href='<c:url value="/giohang/"></c:url>'><img src='<c:url value="/resources/img/icon_shopping_cart.png"></c:url>' />
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
			<div class="col-sm-2 col-md-2">
				<h3>Danh mục</h3>
				<ul class="my-menu">
				<c:forEach var="danhMucSanPham" items="${listDanhMucSanPham}">
					<li><a href="#">${danhMucSanPham.getTenDanhMuc() }</a></li>	
				</c:forEach>			
				</ul>
			</div>
			<div class="col-sm-8 col-md-8">
				<div class="row">
					<div class="col-sm-4 col-md-4">
						<img src='<c:url value="/resources/img/sanpham/${sanPham.getHinhSanPham() }"></c:url>' 
						style="max-width: 100%;">
					</div>
					<div class="col-sm-8 col-md-8">
						<h3 id="tensanpham" data-masanpham="${sanPham.getMaSanPham() }">${sanPham.getTenSanPham() }</h3>
						<h4 id="giatien" data-giatien="${sanPham.getGiaTien() }" style="color:red;">
						${sanPham.getGiaTien() } VNĐ
						</h4>
						<table class="table">
							<thead>
								<tr>
									<td><h5>Màu sắc</h5></td>
									<td><h5>Size</h5></td>
									<td><h5>Số lượng</h5></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="chiTietSanPham" items="${sanPham.getSetChiTietSanPham() }">
									<tr>
										<td class="mau" data-mamau="${chiTietSanPham.getMauSanPham().getMaMau() }">${chiTietSanPham.getMauSanPham().getTenMau() }</td>
										<td class="size" data-masize="${chiTietSanPham.getSizeSanPham().getMaSize() }">${chiTietSanPham.getSizeSanPham().getSize() }</td>
										<td class="soluong">${chiTietSanPham.getSoLuong() }</td>
										<td><button class="btn btn-success btn-giohang" data-machitiet="${chiTietSanPham.getMaChiTietSanPham()}">Thêm vào giỏ hàng</button></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>
				</div>
			</div>
				
			<div class="col-sm-2 col-md-2">
				<span>${sanPham.getMoTa() }</span>
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