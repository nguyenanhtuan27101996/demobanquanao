<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web
	Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href='<c:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css"></c:url>'>
<!-- Custom CSS -->
<link rel="stylesheet"
	href='<c:url value="/resources/css1/style.css"></c:url>'>
<link rel="stylesheet"
	href='<c:url value="/resources/css1/morris.css"></c:url>'>

<!-- Graph CSS -->
<link rel="stylesheet"
	href='<c:url value="/resources/css1/font-awesome.css"></c:url>'>
<!-- jQuery -->
<script src='<c:url value="/resources/js/jquery-3.3.1.min.js"></c:url>'></script>
<!-- //jQuery -->
<link
	href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet"
	href='<c:url value="/resources/css1/icon-font.min.css"></c:url>'>
<!-- //lined-icons -->
</head>
<body>
	<div class="page-container">
	
		<!--/content-inner-->
		<div class="left-content container">
			<div class="row" style="margin-left: 20px;">
				<h3 class="text-center" style="color: #1b93e1;">Hóa đơn</h3>

				<div class="col-md-12">
					<table id="table-hoadon" class="table">
						<thead>
							<th>Tên khách hàng</th>
							<th>Số điện thoại</th>
							<th>Địa chỉ</th>
							<th>Tình trạng</th>
							<th>Ngày lập</th>
							<th>Hình thức giao hàng</th>
							<th>Ghi chú</th>
							
						</thead>
						<tbody>
							<c:forEach var="hoaDon" items="${listHoaDonLimit }">
								<tr>
									
									<td>${hoaDon.getTenKhachHang() }</td>
									<td>${hoaDon.getSoDienThoai() }</td>
									<td>${hoaDon.getDiaChiKhachHang() }</td>
									<td>
										<select class="form-control" id="tinhtrang" name="tinhtrang" class="tinhtrang">
											<c:choose>
												<c:when test="${hoaDon.getTinhTrang() == false }">
													<option value="0" selected="selected">Chưa giao</option>
													<option value="1">Đã giao</option>
												</c:when>
												<c:otherwise>
													<option value="0">Chưa giao</option>
													<option value="1" selected="selected">Đã giao</option>
												</c:otherwise>
											</c:choose>
										</select>
									</td>
									<td>${hoaDon.getNgayLap() }</td>
									<td>${hoaDon.getHinhThucGiaoHang() }</td>
									<td>${hoaDon.getGhiChu() }</td>
									<td><a href='<c:url value='/chitiethoadon/${hoaDon.getMaHoaDon() }'></c:url>'>Chi tiết</a></td>
									<td><button class="btn btn-success btn-suahoadon" data-mahoadon="${hoaDon.getMaHoaDon() }">Cập nhật</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="text-center" id="div-pagination-hoadon" data-tongsotrang="${tongSoTrang}">
					<ul class="pagination">
						<c:choose>
							<c:when test="${tongSoTrang <= 3 }">
								<c:forEach var="element" begin="1" end="3">
									<c:choose>
										<c:when test="${element == 1 }">
											<li class="active pagination-item-hoadon"><a href="#">${element }</a></li>
										</c:when>
										<c:otherwise>
											<li class="pagination-item-hoadon"><a href="#">${element }</a></li>
										</c:otherwise>
									</c:choose>	
								</c:forEach>
							</c:when>
							
							<c:otherwise>
								<li class="previous-page-hoadon"><a href="#"><</a></li>
								<c:forEach var="element" begin="1" end="3">
									<c:choose>
										<c:when test="${element == 1 }">
											<li class="active pagination-item-hoadon"><a href="#">${element }</a></li>
										</c:when>
										<c:otherwise>
											<li class="pagination-item-hoadon"><a href="#">${element }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<li class="forward-page-hoadon"><a href="#">></a></li>
							</c:otherwise>
						</c:choose>
						
					</ul>
				</div>








			</div>
			
		</div>
	
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo1">
				<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a>
			</header>
			<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
			<div class="menu">
				<ul id="menu">
					<li><a href='<c:url value="/dashboard/"></c:url>'><i class="fa fa-tachometer"></i>
							<span>Dashboard</span>
						<div class="clearfix"></div></a></li>


					<li id="menu-academico"><a href='<c:url value="/themsanpham/"></c:url>'><i
							class="fa fa-cube nav_icon"></i><span>Sản phẩm</span>
						<div class="clearfix"></div></a></li>
					<li><a href='<c:url value="/hoadon/"></c:url>'><i class="fa fa-picture-o"
							aria-hidden="true"></i><span>Hóa đơn</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href='<c:url value="/danhmucsanpham/"></c:url>'><i
							class="fa fa-bar-chart"></i><span>Danh mục sản phẩm</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-list-ul" aria-hidden="true"></i><span> Short
								Codes</span> <span class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="icons.html">Icons</a></li>
							<li id="menu-academico-avaliacoes"><a
								href="typography.html">Typography</a></li>
							<li id="menu-academico-avaliacoes"><a href="faq.html">Faq</a></li>
						</ul></li>
					<li id="menu-academico"><a href="errorpage.html"><i
							class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error
								Page</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i class="fa fa-cogs"
							aria-hidden="true"></i><span> UI Components</span> <span
							class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="button.html">Buttons</a></li>
							<li id="menu-academico-avaliacoes"><a href="grid.html">Grids</a></li>
						</ul></li>
					<li><a href="tabels.html"><i class="fa fa-table"></i> <span>Tables</span>
						<div class="clearfix"></div></a></li>
					<li><a href="maps.html"><i class="fa fa-map-marker"
							aria-hidden="true"></i> <span>Maps</span>
						<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-file-text-o"></i> <span>Pages</span> <span
							class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-boletim"><a href="calendar.html">Calendar</a></li>
							<li id="menu-academico-avaliacoes"><a href="signin.html">Sign
									In</a></li>
							<li id="menu-academico-avaliacoes"><a href="signup.html">Sign
									Up</a></li>


						</ul></li>
					<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span>
							<span class="fa fa-angle-right" style="float: right"></span>
						<div class="clearfix"></div></a>
						<ul>
							<li><a href="input.html"> Input</a></li>
							<li><a href="validation.html">Validation</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
		</div>
	
	<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
	<!--js -->
	<script
		src='<c:url value="/resources/js/jquery.nicescroll.js"></c:url>'></script>
	<script src='<c:url value="/resources/js/scripts.js"></c:url>'></script>

	<!-- Bootstrap Core JavaScript -->
	<link rel="stylesheet"
		href='<c:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.min.css"></c:url>'>
	<!-- /Bootstrap Core JavaScript -->
	<!-- morris JavaScript -->
	<script src='<c:url value="/resources/js/raphael-min.js"></c:url>'></script>
	<script src='<c:url value="/resources/js/morris.js"></c:url>'></script>
	<script>
	$(document).ready(function() {
		//BOX BUTTON SHOW AND CLOSE
	   jQuery('.small-graph-box').hover(function() {
		  jQuery(this).find('.box-button').fadeIn('fast');
	   }, function() {
		  jQuery(this).find('.box-button').fadeOut('fast');
	   });
	   jQuery('.small-graph-box .box-close').click(function() {
		  jQuery(this).closest('.small-graph-box').fadeOut(200);
		  return false;
	   });
	   
	    //CHARTS
	    function gd(year, day, month) {
			return new Date(year, month - 1, day).getTime();
		}
		
		graphArea2 = Morris.Area({
			element: 'hero-area',
			padding: 10,
        behaveLikeLine: true,
        gridEnabled: false,
        gridLineColor: '#dddddd',
        axes: true,
        resize: true,
        smooth:true,
        pointSize: 0,
        lineWidth: 0,
        fillOpacity:0.85,
			data: [
				{period: '2014 Q1', iphone: 2668, ipad: null, itouch: 2649},
				{period: '2014 Q2', iphone: 15780, ipad: 13799, itouch: 12051},
				{period: '2014 Q3', iphone: 12920, ipad: 10975, itouch: 9910},
				{period: '2014 Q4', iphone: 8770, ipad: 6600, itouch: 6695},
				{period: '2015 Q1', iphone: 10820, ipad: 10924, itouch: 12300},
				{period: '2015 Q2', iphone: 9680, ipad: 9010, itouch: 7891},
				{period: '2015 Q3', iphone: 4830, ipad: 3805, itouch: 1598},
				{period: '2015 Q4', iphone: 15083, ipad: 8977, itouch: 5185},
				{period: '2016 Q1', iphone: 10697, ipad: 4470, itouch: 2038},
				{period: '2016 Q2', iphone: 8442, ipad: 5723, itouch: 1801}
			],
			lineColors:['#ff4a43','#a2d200','#22beef'],
			xkey: 'period',
            redraw: true,
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
			pointSize: 2,
			hideHover: 'auto',
			resize: true
		});
		
	   
	});
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>