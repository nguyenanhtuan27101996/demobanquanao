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
	<div id="header" class="container-fluid">
		<nav class="navbar navbar-default none-nav">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href='<c:url value="/"></c:url>'><img
					src='<c:url value='resources/img/icon_yame_shop.png'></c:url>' /></a>
			</div>
			<ul class="nav navbar-nav navbar-center">
				<li class="active"><a href="#">TRANG CHỦ</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">SẢN PHẨM <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach var="danhMucSanPham" items="${listDanhMucSanPham}">
							<li><a href="sanpham/${danhMucSanPham.getMaDanhMuc() }/${danhMucSanPham.getTenDanhMuc() }">
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
						<li><a href="dangnhap/" class="circle-avatar"><span>${sessionTenDangNhap }</span></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="dangnhap/">ĐĂNG NHẬP</a></li>
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

		<div class="event-header container wow rubberBand"
			data-wow-duration="2s">
			<span>Ngày 28/2 - 23/3/2018</span><br> <span
				style="font-size: 50px;">MUA 1 TẶNG 1</span><br>
			<button>Mua ngay</button>

		</div>
	</div>
	<div id="info" class="container">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4 text-center wow fadeInRight"
				data-wow-duration="1s">
				<img class="icon"
					src='<c:url value="resources/img/icon_chatluong.png"></c:url>'><br>
				<span style="font-size: 32px; font-weight: 500;">CHẤT LƯỢNG</span><br>
				<span>Chúng tôi cam kết sẽ mang đến chất lượng sản phẩm tốt
					nhất</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 text-center wow fadeInDown"
				data-wow-duration="1s" data-wow-delay="1s">
				<img class="icon"
					src='<c:url value="resources/img/icon_conheo.png"></c:url>'><br>
				<span style="font-size: 32px; font-weight: 500;">CHẤT LƯỢNG</span><br>
				<span>Cam kết bán giá rẻ nhất Việt Nam giúp các bạn tiết kiệm
					hơn 20% cho từng sản phẩm</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 text-center wow fadeInUp"
				data-wow-duration="1s" data-wow-delay="2s">
				<img class="icon"
					src='<c:url value="resources/img/icon_giaohang.png"></c:url>'><br>
				<span style="font-size: 32px; font-weight: 500;">CHẤT LƯỢNG</span><br>
				<span>Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm
					đến cho khách hàng nhanh nhất</span>
			</div>
		</div>

	</div>
	<div id="title-product" class="container">
		<span>SẢN PHẨM HOT</span>
		
		<div class="row" style="margin-top: 46px;">
			<c:forEach var="sanPham" items="${listSanPham }">
				<a href="chitiet/${sanPham.getMaSanPham() }">
					<div class="col-md-3 col-sm-6">
						<div class="sanpham wow zoomIn">
							<img
								src='<c:url value="resources/img/sanpham/${sanPham.getHinhSanPham() }"></c:url>' />
							<br> <span>${sanPham.getTenSanPham() }</span> <br> <span
								class="giatien-trangchu">${sanPham.getGiaTien() } VNĐ</span>
						</div>
					</div>
				</a>
			</c:forEach>
			
			<!-- end san pham -->
		</div>
	</div>
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow tada">
				<p class="text-center">
					<span class="title-footer">THÔNG TIN SHOP</span>
				</p>
				<span>Yame là một thương hiệu thời trang đầy uy tín, luôn đảm
					bảo chất lượng sản phẩm tốt nhất cho khách hàng</span>

			</div>
			<div class="col-sm-4 col-md-4 wow tada">
				<p class="text-center">
					<span class="title-footer">LIÊN HỆ</span>
				</p>
				<span>262 Thụy Khuê, quận Tây Hồ, Hà Nội</span> <span>nguyenanhtuan27101996@gmail.com</span>
				<span>01636218566</span>
			</div>
			<div class="col-sm-4 col-md-4 wow tada">
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