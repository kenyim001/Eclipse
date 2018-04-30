<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>image</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="style/bootstrap-theme.min.css">
<link rel="stylesheet" href="style/input.css">

</head>
  
<body>
<div id="content">
<div id="form_in">
<div id="form">
<div id="text">
<form action="ImgUpload" method="post" enctype="multipart/form-data" >
<!-- 下面的id别改动 别重复-->
<p><label> </label> <input type="file" id="file" name="fileName" onchange="fileupload()"/></p>
<p><label id="filename"><%=request.getParameter("filename")%> </label> <input type="submit" value="提交" id="sub" hidden="hidden"/></p>

</form>
</div>
<div id="er"><img src="" id="qr_img"></div>
</div>
</div>
<div id="button">
<input type="button" id="begin" class="btn btn-success" value="生成" />
<a class="btn btn-success" type="button" onclick="clean()">清空</a>
</div>
</div>
</body>

	<script type="text/javascript" src="js/jquery.js"> </script>
	<script type="text/javascript" src="js/html2canvas.js"></script>
	<script type="text/javascript" src="ajaxfileupload.js"></script> 
<script type="text/javascript">

	alert("功能后续开通");
	function fileupload(){
		$("#sub").click();
	}
	
	$(function(){
		 $("#begin").click(function(){createCode();});
		 
	});
	function createCode(){
		var str;
		var str = "http://127.0.0.1:8080/postcard/upload/"+document.getElementById("filename").innerHTML;
		$.ajax({
			type:"post",
			url:"qrcode",
			data:{content:str},
			success:function(data){
			$("#qr_img").fadeIn("slow");
				$("#qr_img").attr("src","qrcode/"+data);
			}
		});
		
	}
	
	function print(){
		html2canvas( $("#form_in") , 
		{
	  		onrendered: function(canvas) 
	  		{   
	    		$('#print').attr( 'href' , canvas.toDataURL() ) ;
	    		$('#print').attr( 'download' , 'myjobdeer.png' ) ;
	    		//$('#print').css('display','inline-block');
	  		}
	  	});
	}
	
	function clean(){
		$("form").find(':input').not(':button,:submit,:reset').val('').removeAttr('checked').removeAttr('selected');
		$("#qr_img").attr("src","");
	}
</script>