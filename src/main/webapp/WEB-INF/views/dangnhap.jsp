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
<body id="body-login">

	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
					<span id="text-logo">Welcome</span><br> <span
						id="hint-text-logo">Hãy tạo nên phong cách của bạn cùng
						Minishop !</span>
				</div>
				<div id="header-bottom-left">
					<p>
						<img alt="icon_oval"
							src='<c:url value="/resources/img/icon_oval.png"></c:url>'><span>Luôn
							cập nhật xu hướng thời trang mới nhất</span>
					</p>
					<p>
						<img alt="icon_oval"
							src='<c:url value="/resources/img/icon_oval.png"></c:url>'><span>Giảm
							hơn 50% tất cả các mặt hàng cho khách VIP</span>
					</p>
					<p>
						<img alt="icon_oval"
							src='<c:url value="/resources/img/icon_oval.png"></c:url>'><span>Tận
							tình tư vấn để tạo nên phong cách cho bạn</span>
					</p>
				</div>
			</div>
			<div id="container-login-right">
				<div class="header-login" id="header-top-right">
					<span id="dangnhap" class="actived">Đăng nhập</span>/<span id="dangky">Đăng ký</span>
				</div>
				
				<div id="containter-center-login-right">
					<div id="containter-center-login-right" class="container-login-form ">
						<input id="txtTenDangNhap" class="material-textinput input-icon-email"
							type="text" placeholder="Email" name="email"> <br> 
						<input
							id="txtMatKhau" class="material-textinput input-icon-password"
							type="password" placeholder="Mật khẩu" name="matKhau"> <br>
						 <input
							id="btnLogin" class="material-primary-button" type="submit"
							value="ĐĂNG NHẬP"> <br>
					</div>
					
					<div id="containter-center-login-right" class="container-register-form">
						<form action="" method="post">
							<input id="txtTenDangKy" class="material-textinput input-icon-email"
							type="text" placeholder="Email" name="email"> <br> 
							<input
							id="txtMatKhauDangKy" class="material-textinput input-icon-password"
							type="password" placeholder="Mật khẩu" name="matKhau"> <br>
							<input
							id="txtNhapLaiMatKhau" class="material-textinput input-icon-password"
							type="password" placeholder="Nhập lại Mật khẩu" name="nhapLaiMatKhau"> <br>
						 	<input
							id="btnRegister" class="material-primary-button" type="submit"
							value="ĐĂNG KÝ"> <br>
						</form>
						
					</div>
					<br>
					<span id="ketqua" style="color: red"></span>
					<span style="color: red;">${kiemTraDangKy }</span>
					<span id="dangky-sai" style="display: none;">${dangKySai }</span>
				</div>
				
				<div id="container-social-login">
					<img alt="icon_oval"
						src='<c:url value="/resources/img/icon_facebook.png"></c:url>'>
					<img alt="icon_oval"
						src='<c:url value="/resources/img/icon_google.png"></c:url>'>
				</div>
				
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>