<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>表单</title>
<link rel="stylesheet" href="style/index.css">
<link rel="stylesheet" href="style/bootstrap-theme.min.css">

</head>

<body>
	<div id="content">
		<div id="form_in">
			<img src="images/big_1.png" id="a" />
			<div id="form">
				<div id="text">
					<form action="#" method="post" id="postcardform">
						<p>
							<label>姓名：</label><input type="text" name="name" id="name"
								value="" />
						</p>
						<p>
							<label>公司：</label><input type="text" name="company" id="company"
								value="" />
						</p>
						<p>
							<label>职位：</label><input type="text" name="position"
								id="position" value="" />
						</p>
						<p>
							<label>电话：</label><input type="text" name="phone" id="phone"
								value="" />
						</p>
						<p>
							<label>E-mail：</label><input type="text" name="email" id="email"
								value="" />
						</p>
						<p>
							<label>地址：</label><input type="text" name="address" id="address"
								value="" />
						</p>


					</form>
				</div>
				<div id="er">
					<img src="" id="qr_img" /> <img src="" id="logo_img" class="zj" />
				</div>
			</div>
		</div>
		<div id="picture">
			<ul>
				<li><img src="images/small_1.png"onclick="MM_swapImage('a','','images/big_1.png',1)" /></li>
				<li><img src="images/small_2.png"onclick="MM_swapImage('a','','images/big_2.png',1)" /></li>
				<li><img src="images/small_3.png"onclick="MM_swapImage('a','','images/big_3.png',1)" /></li>
				<li><img src="images/small_4.png"onclick="MM_swapImage('a','','images/big_4.png',1)" /></li>
				<li><img src="images/small_5.png"onclick="MM_swapImage('a','','images/big_5.png',1)" /></li>
			</ul>
		</div>
		<div id="button">
			<!-- 上传文件表单 内有一个按钮和一个隐藏label -->
			<form action="ImgUpload" method="post" enctype="multipart/form-data"
				id="fileform">
				<div class="btn btn-success" id="yincang">
					上传LOGO <input type="file" id="file" class="filename"
						name="fileName" onchange="fileupload()" />

				</div>
				<label id="filename" hidden="hidden"><%=request.getParameter("filename")%>
				</label>
			</form>
			<input type="button" id="begin" class="btn btn-success" value="生成" />
			<a id="print" class="btn btn-success" onclick="print()">打印</a> <a
				class="btn btn-success" onclick="clean()">清空</a>
		</div>
	</div>
</body>

<script type="text/javascript" src="js/jquery.js">
	
</script>
<script type="text/javascript" src="js/html2canvas.js"></script>

<script type="text/javascript">
console.log(path);
console.log(basePath);
	function MM_preloadImages() { //v3.0
		var d = document;
		if (d.images) {
			if (!d.MM_p)
				d.MM_p = new Array();
			var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
			for (i = 0; i < a.length; i++)
				if (a[i].indexOf("#") != 0) {
					d.MM_p[j] = new Image;
					d.MM_p[j++].src = a[i];
				}
		}
	}

	function MM_swapImgRestore() { //v3.0
		var i, x, a = document.MM_sr;
		for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
			x.src = x.oSrc;
	}

	function MM_findObj(n, d) { //v4.01
		var p, i, x;
		if (!d)
			d = document;
		if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
			d = parent.frames[n.substring(p + 1)].document;
			n = n.substring(0, p);
		}
		if (!(x = d[n]) && d.all)
			x = d.all[n];
		for (i = 0; !x && i < d.forms.length; i++)
			x = d.forms[i][n];
		for (i = 0; !x && d.layers && i < d.layers.length; i++)
			x = MM_findObj(n, d.layers[i].document);
		if (!x && d.getElementById)
			x = d.getElementById(n);
		return x;
	}

	function MM_swapImage() { //v3.0
		var i, j = 0, x, a = MM_swapImage.arguments;
		console.log(a.lenght);
		document.MM_sr = new Array;
		for (i = 0; i < (a.length - 2); i += 3)
			if ((x = MM_findObj(a[i])) != null) {
				document.MM_sr[j++] = x;
				if (!x.oSrc)
					x.oSrc = x.src;
				x.src = a[i + 2];
			}
	}

	function fileupload() {
		$("#postcardform").submit();
		$("#fileform").submit();

	}

	$(function() {
		$("#begin").click(function() {
			createCode();
			logo()
		});

	});
	function logo() {
		var filename = document.getElementById("filename").innerHTML;
		$("#logo_img").attr("src",
				"http://127.0.0.1:8080/postcard/upload/" + filename);
		$("#logo_img").attr("height", "60px");
		$("#logo_img").attr("width", "60px");
	}
	function createCode() {
		var name = "", company = "", title = "", tel = "", address = "", email = "";
		name = $("#name").val();
		company = $("#company").val();
		title = $("#position").val();
		tel = $("#phone").val();
		address = $("#address").val();
		email = $("#email").val();

		var str = "BEGIN:VCARD\nFN:" + name + "\nORG:" + company + "\nTITLE:"
				+ title + "\nTEL:" + tel + "\nADR:" + address + "\nEMAIL:"
				+ email + "\nEND:VCARD";
		$.ajax({
			type : "post",
			url : "qrcode",
			data : {
				content : str
			},
			success : function(data) {
				$("#qr_img").fadeIn("slow");
				$("#qr_img").attr("src", "qrcode/" + data);
			}
		});

	}

	function print() {
		html2canvas($("#form_in"), {
			onrendered : function(canvas) {
				$('#print').attr('href', canvas.toDataURL());
				$('#print').attr('download', 'myjobdeer.png');
				//$('#print').css('display','inline-block');
			}
		});
	}

	function clean() {
		$("form").find(':input').not(':button,:submit,:reset').val('')
				.removeAttr('checked').removeAttr('selected');
		$("#qr_img").attr("src", "");
	}
</script>

</html>
