<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Motel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<script src="js/jquery-1.11.1.min.js"></script>
<!--webfonts-->
<!-- <link href='http://fonts.useso.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Open+Sans:400,300italic,300,600' rel='stylesheet' type='text/css'> -->
<!--//webfonts-->
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/login_head.js"></script>
</head>
<body>
<!-- banner -->
	<div class="banner1">
		<div class="header">
			<div class="container">
				<div class="logo">
					<h1><a href="index.html"><b>BZ酒店</b></a></h1>
				</div>
					<nav class="navbar navbar-default" role="navigation">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<!--/.navbar-header-->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								
								<li><a href="index.do">主页</a></li>
								<li><a href="rooms.do">房间</a></li>
								<li><a href="offersUI.do">优惠</a></li>
								<li><a href="userUI.do">预约信息</a></li>
								<li class="active"><a href="toLogin.do">登录</a></li>
								<li><a href="hotelUI.do">后台</a></li>
								
							</ul>
						</div>
						<!--/.navbar-collapse-->
					</nav>
				<!-- <div class="search-box">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
							<input class="sb-search-submit" type="submit" value="">
							<span class="sb-icon-search"> </span>
							</form>
					</div>
				</div> -->
				
				
				<%@ include file="common/login_head.jsp" %>
				
					<div class="clearfix"> </div>

				<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
					<script>
						new UISearch( document.getElementById( 'sb-search' ) );
					</script>
				<!-- //search-scripts -->

			</div>
		</div>
	</div>		
		<!-- banner -->
<!-- registration -->
	<div class="main-1">
		<div class="container">
			<div class="register">
		  	  <form action="modify.do" method="post"> 
				 <div class="register-top-grid">
					<h3>修改个人信息</h3>
					
					 <div class="name" data-wow-delay="0.4s">
						<span>名字<label>*</label></span>
						<input type="text" name="name" value="${user.name}"> 
					 </div>
					 <div class="gender" data-wow-delay="0.4s">
						<span>性别<label>*</label></span>
						<input type="text" name="gender" value='${user.gender}'> 
					 </div>
					  <div class="telephone" data-wow-delay="0.4s">
						<span>电话号码<label>*</label></span>
						<input type="text" name="telephone" value='${user.telephone}' disabled="true"> 
					 </div>
					  <div class="email" data-wow-delay="0.4s">
						<span>邮箱地址<label>*</label></span>
						<input type="text" name="email" value='${user.email}'> 
					 </div>
					 
					  <div class="accountNumber" data-wow-delay="0.4s">
								<span>帐号<label>*</label></span>
								<input type="text" name="accountNumber" value='${user.accountNumber}'>
					 </div>
					 
					 <div class="password" data-wow-delay="0.4s">
								<span>密码<label>*</label></span>
								<input type="password" name="password" value='${user.password}'>
					 </div>
					 
					 <input type="submit" value="提交" onclick='alert("修改成功")' >
					 
					  <div class="clearfix"> </div>
					</div>
				</form>
				<div class="clearfix"> </div>
				<div class="register-but">
	
				</div>
		   </div>
		 </div>
	</div>
<!-- registration -->
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-2 deco">
				<h4>导航</h4>
				<li><a href="index.html">主页</a></li>
				<li><a href="shortcodes.html">XXX/XXX </a></li>
				<li><a href="sigin.html">登录</a></li> 
				<li><a href="contact.html">联系我们</a></li>
			</div>
			<div class="col-md-2 deco">
				<h4>链接</h4> 
				<li><a href="#">影院</a></li>
				<li><a href="#">美食</a></li>
				<li><a href="#">购物</a></li>
			</div>
			<div class="col-md-2 deco">
				<h4>分享</h4>
				<div class="soci"> 
					<li><a href="#" ><img src="images/weixin.jpg"></i></a></li>
					<li><a href="#" ><img src="images/weibo.jpg"> </i></a></li>
					<li><a href="#" ><img src="images/qq.jpg"> </i></a></li>
				</div>
			</div>
			<div class="col-md-3 cardss">
				<h4>支付方式</h4>
				<li><i class="visa"></i></li>
				<li><i class="ma"></i></li>
				<li><i class="paypal"></i></li>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-3 pos">
			<h4>订阅</h4>
					   <form method="post">
						 <input type="text" class="textbox" value="电子邮箱" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email';}">
						 <div class="smt">
							<input type="submit" value="确定">
						 </div>
					   </form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<div class="footer-bottom">
			<div class="container">
				<p>Copyright &copy; 2017 BZ No.1
</p>
			</div>
		</div>
	<!-- footer -->
</body>
</html>