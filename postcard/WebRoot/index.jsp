	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="shortcut icon" type="image/ico" href="/favicon.ico">
    <title>路人甲 二维码名片生成系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="style/bootstrap.min.css">
	<link rel="stylesheet" href="style/bootstrap-theme.min.css">
	<link rel="stylesheet" href="style/css.css">
	<link rel="stylesheet" href="style/index.css">


  </head>
  
  <body>
  ﻿<div class="navbar navbar-fixed-top navbar-inverse">
   <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">主页</a></li>
            <li><a href="#">官方主页</a></li>
            <li><a href="join.html">加入我们</a></li>
            <li><a href="friend/index.html">关于我们</a></li>
		    <li><a href="changelog.html">更新日志</a></li>
          </ul>  		  
	     </div>
      <iframe id="tmp_downloadhelper_iframe" style="display: none;"></iframe>
      </div>
    </div>
<div class="container">
<div class="col-sm-3">
	<div class="panel panel-default">
		<div class="panel-heading">
        <a style="color: #2a6496;" href="">最新公告：</a></div> 
			<div class="panel-body">
            <p>
            部分浏览器与软件问题可能会不支持QRcode的功能，请参照使用说明进行查看。
            </p>	
	</div>
	</div>
	
	
	
	<div class="panel panel-default">
		<div class="panel-heading"><a style="color: #2a6496;" >在线应用</a></div> 
			<div class="panel-body">
      			<ul class="nav nav-stacked">
								<li><a href="postcard.jsp" target="main">名片生成系统</a></li>
								<li><a href="text.html" target="main">文字转换系统</a></li>
								<li><a href="wifi.html" target="main">wifi转换系统</a></li>
								<li><a href="image.jsp" target="main">图片转换系统</a></li>
								<li><a href="url.html" target="main">网址转换系统</a></li>
								<li><a href="sms.html" target="main">短信转换系统</a></li>
								<li><a href="tel.html" target="main">电话转换系统</a></li>
								
										</ul>
	</div>
	</div>
</div>
		<div class="col-sm-9">
            	<div class="panel panel-default">
    			<div class="panel-heading">当前应用
               </div>   
	   <iframe src="postcard.jsp" id="frame" name="main"></iframe>
</div>
</div>
</div>
  
  <div id="footer">
  <hr>
  <h2>Copyright©  2015 <a href="127.0.0.1/postcaed/">路人甲</a>&nbsp;&nbsp;&nbsp;<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=635450073&amp;site=qq&amp;menu=yes"><img src="images/qq.gif" title="点击联系我" border="0" alt="联系管理"></a></h2></div>
  </body>
 
 	<script src="js/bootstrap.min.js">	</script>
	<script type="text/javascript" src="js/jquery.js"> </script>


 
</html>
