$(document).ready(function(){
	$("#btnLogin").click(function(){
		var email=$("#txtTenDangNhap").val();
		var matKhau=$("#txtMatKhau").val();
		$.ajax({
			url:"/demo/api/kiemtradangnhap",
			type:"GET",
			data:{
				email:email,
				matKhau:matKhau
			},
			success:function(value){
				if(value == "true"){
					var duongDanHienTai = window.location.href;
					var duongDan = duongDanHienTai.replace("dangnhap/","");
					window.location = duongDan;
				}else{
					$("#ketqua").html("");
					$("#ketqua").append("Đăng nhập thất bại");
				}
			}
		});
	});
	
	$("#dangnhap").click(function(){
		$(this).addClass("actived");
		$("#dangky").removeClass("actived");
		$(".container-login-form").show();
		$(".container-register-form").hide();
		
	});
	$("#dangky").click(function(){
		$(this).addClass("actived");
		$("#dangnhap").removeClass("actived");
		$(".container-login-form").hide();
		$(".container-register-form").show();
		
	});
	
	var dangKySai=$("#dangky-sai").html();
	if(dangKySai=="false"){
		$("#dangky").addClass("actived");
		$("#dangnhap").removeClass("actived");
		$(".container-login-form").hide();
		$(".container-register-form").show();
	}
	
	$(".btn-giohang").click(function(){
		var maChiTiet=$(this).attr("data-machitiet");
		var maMau=$(this).closest("tr").find(".mau").attr("data-mamau");
		var tenMau=$(this).closest("tr").find(".mau").text();
		var maSize=$(this).closest("tr").find(".size").attr("data-masize");
		var size=$(this).closest("tr").find(".size").text();
		var soLuong=$(this).closest("tr").find(".soluong").text();
		var tenSanPham=$("#tensanpham").text();
		var maSanPham=$("#tensanpham").attr("data-masanpham");
		var giaTien=$("#giatien").attr("data-giatien");
		
		$.ajax({
			url:"/demo/api/themgiohang",
			type:"GET",
			data:{
				maSanPham:maSanPham,
				maSize:maSize,
				maMau:maMau,
				tenSanPham:tenSanPham,
				giaTien:giaTien,
				tenMau:tenMau,
				size:size,
				soLuong:soLuong,
				maChiTiet:maChiTiet
				
			},
			success:function(value){
					$("#cart-shopping").find("div").addClass("circle-shopping-cart");
					$("#soLuongSpGioHang").html("");
					$("#soLuongSpGioHang").html(value);
			}				
		});
		
	});
	
	ganTongTienGioHang();
	function ganTongTienGioHang(){
		var tongTienSp=0;
		$(".giatien").each(function(){
			//var giaTien=$(this).text();
			//lay ra so luong cua san pham tu input
			var soLuong=$(this).closest("tr").find(".soluong-giohang").val();
			//lay ra gia tien goc cua san pham
			var giaTienGoc=$(this).attr("data-giatiengh");
			//tong tien =  tong tien + (giagoc * soluong)
			tongTienSp+=(parseInt(giaTienGoc) * soLuong);
			
			//format tong tien
			var format=tongTienSp.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
			//format gia tien tung san pham
			var formatGiaTienSp=(parseInt(giaTienGoc) * soLuong).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
			
			$(this).html(formatGiaTienSp.replace(".",","));
			$("#tongTien").html(format.replace(".",",")+" VNĐ");
		});
	}
	
	$(".soluong-giohang").change(function(){
		var soLuong=parseInt($(this).val());
		var giaTien=$(this).closest("tr").find(".giatien").attr("data-giatiengh");
		var giaTienMoi=parseInt(soLuong) * parseInt(giaTien);
		
		var format=giaTienMoi.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
		$(this).closest("tr").find(".giatien").text(format.replace(".",","));
		
		ganTongTienGioHang();
		
		
		
	});
	
	$(".soluong-giohang").blur(function(){
		
		
		var soLuong=parseInt($(this).val());
		var maSanPham=parseInt($(this).closest("tr").find(".tensanpham-giohang").attr("data-masanpham-giohang"));
		var maSize=parseInt($(this).closest("tr").find(".mausanpham-giohang").attr("data-mamau-giohang"));
		var maMau=parseInt($(this).closest("tr").find(".size-giohang").attr("data-masize-giohang"));
		
		$.ajax({
			url:"/demo/api/capnhatgiohang",
			type:"GET",
			data:{
				maSanPham:maSanPham,
				maSize:maSize,
				maMau:maMau,
				soLuong:soLuong
				
			},
			success:function(value){
				
			}				
		});
	});
	
	$(".btn-xoagiohang").click(function(){
		var self=$(this);
		var maSanPham=parseInt($(this).closest("tr").find(".tensanpham-giohang").attr("data-masanpham-giohang"));
		var maSize=parseInt($(this).closest("tr").find(".mausanpham-giohang").attr("data-mamau-giohang"));
		var maMau=parseInt($(this).closest("tr").find(".size-giohang").attr("data-masize-giohang"));
		
		$.ajax({
			url:"/demo/api/xoagiohang",
			type:"GET",
			data:{
				maSanPham:maSanPham,
				maSize:maSize,
				maMau:maMau	
			},
			success:function(value){
				self.closest("tr").remove();
				ganTongTienGioHang();
			}				
		});
		
	});
	
	$("body").on("click",".pagination-item",function(){
		$(".pagination-item").removeClass("active");
		$(this).addClass("active");
		var soTrang=$(this).text();
		var sanPhamBatDau=(soTrang-1)*5;
		
	
		$.ajax({
			url:"/demo/api/phantrangsanpham",
			type:"GET",
			data:{
				sanPhamBatDau:sanPhamBatDau
				
				
			},
			success:function(value){
				var tbodysanpham = $("#table-sanpham").find("tbody");
				tbodysanpham.empty();
				tbodysanpham.append(value);
			}				
		});
	})
	
	$("body").on("click",".forward-page",function(){
		var soTrangMaxHienTai=0;
		var tongSoTrang=$("#div-pagination").attr("data-tongsotrang");
		
		$(".pagination-item").each(function(){
			soTrangMaxHienTai=$(this).find(":last-child").text();
		});
		
		if(parseInt(soTrangMaxHienTai) < parseInt(tongSoTrang)){
			var divpagination=$("#div-pagination").find("ul");
			divpagination.empty();
			var html = "<ul class='pagination'>";
			html += "<li class='previous-page'><a href='#'><</a></li>";
			
			if(parseInt(tongSoTrang) < (parseInt(soTrangMaxHienTai)+3)){
				for(var i=parseInt(soTrangMaxHienTai)+1 ; i<= parseInt(tongSoTrang) ; i++){
					html+= "<li class='pagination-item'><a href='#'>"+i+"</a></li>";
				}
			}else{
				for(var i=parseInt(soTrangMaxHienTai)+1 ; i<=parseInt(soTrangMaxHienTai)+3 ; i++){
					html+= "<li class='pagination-item'><a href='#'>"+i+"</a></li>";
				}
			}
			
			html += "<li class='forward-page'><a href='#'>></a></li>";
			html += "</ul>";
			
			divpagination.append(html);
		}
		
	});
	
	$("body").on("click",".previous-page",function(){
		var soTrangMinHienTai=0;
		
		soTrangMinHienTai=$(".pagination-item").first().text();
		
		if(parseInt(soTrangMinHienTai) >= 4){
			$(".pagination-item").removeClass("active");
			var divpagination=$("#div-pagination").find("ul");
			divpagination.empty();
			var html = "<ul class='pagination'>";
			html += "<li class='previous-page'><a href='#'><</a></li>";
			for(var i=parseInt(soTrangMinHienTai)-3 ; i<=parseInt(soTrangMinHienTai)-1; i++){
				html+= "<li class='pagination-item'><a href='#'>"+i+"</a></li>";
			}
			html += "<li class='forward-page'><a href='#'>></a></li>";
			html += "</ul>";
			
			divpagination.append(html);
		}
		
		
	});
	$("#check-all").change(function(){
		if(this.checked){
			$("#table-sanpham input").attr("checked",true);
		}else{
			$("#table-sanpham input").attr("checked",false);
		}
	});
	$("#btn-xoasanpham").click(function(){
		$("#table-sanpham >tbody input:checked").each(function(){
			var maSanPham = parseInt($(this).attr("value"));
			
			var self = $(this);
			$.ajax({
				url:"/demo/api/xoasanpham",
				type:"GET",
				data:{
					maSanPham:maSanPham
				},
				success:function(value){
					self.closest("tr").remove();
				}				
			});
		})
	});
	
	var files=[];
	var tenhinhsanpham="";
	$("#hinhanh").change(function(event){
		
		files=event.target.files;
		tenhinhsanpham = files[0].name;
		forms = new FormData();
		forms.append("file",files[0]);
		
		$.ajax({
			url:"/demo/api/uploadhinhanh",
			type:"POST",
			data:forms,
			processData:false,
			enctype:"multipart/form-data",
			contentType:false,
			success:function(value){
				
			}				
		});
	});
	
	$("body").on("click",".btn-themchitietsanpham",function(){
		$(this).remove();
		var chitietsanphamclone = $("#chitietsanpham").clone().removeAttr("id");
		
		$("#container-chitietsanpham").append(chitietsanphamclone);
	});
	
	$("#btn-themsanpham").click(function(event){
		//ngan ko reload page
		event.preventDefault();
		//lay tat ca cac gia tri co trong the form
		var formsanpham = $("#form-sanpham").serializeArray();
		
		var json = {};
		
		$.each(formsanpham,function(i,field){
			json[field.name] = field.value;
		});
		var jsonArrayChiTiet = [];
		
		
		$("#container-chitietsanpham > .chitietsanpham").each(function(){
			var objectChiTiet = {};
			var mausanpham = $(this).find("#mausanpham").val();
			var sizesanpham = $(this).find("#sizesanpham").val();
			var soluong = $(this).find("#soluong").val();
			
			objectChiTiet["mausanpham"] = mausanpham;
			objectChiTiet["sizesanpham"] = sizesanpham;
			objectChiTiet["soluong"] = soluong;
			
			jsonArrayChiTiet.push(objectChiTiet);
		});
		
		json["chitietsanpham"] = jsonArrayChiTiet;
		json["hinhanh"] = tenhinhsanpham;
		console.log(json);
		
		$.ajax({
			url:"/demo/api/themsanpham",
			type:"POST",
			data:{
				jsonSanPham:JSON.stringify(json)
				
			},
			success:function(value){
				
			}				
		});
	});
	
	var masanphamcapnhat = 0;
	$("body").on("click",".btn-capnhatsanpham",function(){
		var masanpham = $(this).attr("data-id");
		masanphamcapnhat = masanpham;
		$("#btn-xacnhancapnhat").removeClass("hidden");
		$("#btn-huycapnhat").removeClass("hidden");
		$("#btn-themsanpham").addClass("hidden");
		
		$.ajax({
			url:"/demo/api/laysanphamtheomasanpham",
			type:"GET",
			data:{
				maSanPham:parseInt(masanpham)
				
			},
			success:function(value){
				$("#tensanpham").val(value.tenSanPham);
				$("#giatien").val(value.giaTien);
				$("#mota").val(value.moTa);
				if(value.gianhCho == "nam"){
					$("#rdonam").prop("checked",true);
				}else{
					$("#rdonu").prop("checked",true);
				}
				
				$("#danhmuc").val(value.danhMucSanPham.maDanhMuc);
				
				$("#container-chitietsanpham").empty();
				
				
				for(var i = 0 ; i < value.setChiTietSanPham.length ; i++){
					var chitietsanphamclone = $("#chitietsanpham").clone().removeAttr("id");
					
					chitietsanphamclone.find("#mausanpham").val(value.setChiTietSanPham[i].mauSanPham.maMau);
					chitietsanphamclone.find("#sizesanpham").val(value.setChiTietSanPham[i].sizeSanPham.maSize);
					chitietsanphamclone.find("#soluong").val(value.setChiTietSanPham[i].soLuong);
					if(i != (value.setChiTietSanPham.length -1)){
						chitietsanphamclone.find(".btn-themchitietsanpham").remove();
					}
					$("#container-chitietsanpham").append(chitietsanphamclone);
				}
				
			}				
		});
	});
	
	$("#btn-xacnhancapnhat").click(function(){
		//ngan ko reload page
		event.preventDefault();
		//lay tat ca cac gia tri co trong the form
		var formsanpham = $("#form-sanpham").serializeArray();
		
		var json = {};
		
		$.each(formsanpham,function(i,field){
			json[field.name] = field.value;
		});
		var jsonArrayChiTiet = [];
		
		
		$("#container-chitietsanpham > .chitietsanpham").each(function(){
			var objectChiTiet = {};
			var mausanpham = $(this).find("#mausanpham").val();
			var sizesanpham = $(this).find("#sizesanpham").val();
			var soluong = $(this).find("#soluong").val();
			
			objectChiTiet["mausanpham"] = mausanpham;
			objectChiTiet["sizesanpham"] = sizesanpham;
			objectChiTiet["soluong"] = soluong;
			
			jsonArrayChiTiet.push(objectChiTiet);
		});
		
		json["chitietsanpham"] = jsonArrayChiTiet;
		json["hinhanh"] = tenhinhsanpham;
		json["masanpham"] = masanphamcapnhat;
		
		
		$.ajax({
			url:"/demo/api/capnhatsanpham",
			type:"POST",
			data:{
				jsonSanPham:JSON.stringify(json)
				
			},
			success:function(value){
				if(value == "true"){
					alert("Cập nhật thành công");
					$("#hinhanh").val("");
				}else{
					alert("Cập nhật không thành công");
				}
			}				
		});
		
	});
	$("#btn-huycapnhat").click(function(){
		$("#tensanpham").val("");
		$("#giatien").val("");
		$("#danhmuc").val("1");
		$("#mota").val("");
		$("#rdonam").prop("checked",true);
		$("#container-chitietsanpham").empty();
		var chitietsanphamclone = $("#chitietsanpham").clone().removeAttr("id");
		$("#container-chitietsanpham").append(chitietsanphamclone);
		$("#btn-xacnhancapnhat").addClass("hidden");
		$("#btn-themsanpham").removeClass("hidden");
		$(this).addClass("hidden");
	})
});
