﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
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
<script type="text/javascript" src="js/hotel_bz.js"></script>

<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<link rel='stylesheet' type='text/css' href="css/information_form.css" />
<script type="text/javascript" src="js/offers_load.js"></script>
<script type="text/javascript" src="js/offers.js"></script>
<script type="text/javascript" src="js/information_form.js"></script>	
<script type="text/javascript" src="js/login_head.js"></script>





</head>
<body>
<!-- banner -->
	<div class="banner">
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
								<li class="active"><a href="index.do">主页</a></li>
								<li><a href="rooms.do">房间</a></li>
								<li><a href="offersUI.do">优惠</a></li>
								<li><a href="userUI.do">预约信息</a></li>
								<li><a href="toLogin.do">登录</a></li>
								<li><a href="hotelUI.do">后台</a></li>
							</ul>
						</div>
						<!--/.navbar-collapse-->
					</nav>
				<!-- 抬头日期 -->
				<!-- <div class="header-date">
						yyyy年MM月dd日<br/>
						hh:mm:ss 周X
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
		<div class="banner-info">
			<div class="container">
				<div class="details-1">
					<div class="col-md-10 dropdown-buttons">   
						<div class="col-md-3 dropdown-button">           			
							<div class="input-group">
								<input class="form-control has-dark-background" name="slider-name" id="slider-name" placeholder="名字/Name" type="text" required="">
							</div>
						</div>
						<!---strat-date-piker---->
							<link rel="stylesheet" href="css/jquery-ui.css" />
							<script src="js/jquery-ui.js"></script>
							  <script>
									  $(function() {
										$( "#datepicker,#datepicker1" ).datepicker();
									  });
							  </script>
						<!---/End-date-piker---->

						<div class="col-md-3 dropdown-button">           			
							<div class="book_date">
								<form>
									<input class="date" id="datepicker" type="text" value="入住时间/Check In" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '入住时间/Check In';}">
								</form>
							</div>		
						</div>
					  <div class="col-md-3 dropdown-button">           			
							<div class="book_date">
								<form>
									<input class="date1" id="datepicker1" type="text" value="退房时间/Check Out" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '退房时间/Check Out';}">
								</form>
							</div>		
						</div>
						<div class="col-md-3 dropdown-button">
						  <div class="section_1">
							 <select id="country" onChange="change_country(this.value)" class="frm-field required">
								<option value="null">双人房/Double Room</option>
								<option value="null">单人房/Sigle Room</option>         
								<option value="AX">舒适房/Suit Room</option>
								<option value="AX">贵宾房/Guest Room</option>
							 </select>
						  </div>
						</div>
						<div class="clearfix"> </div>
					</div> 
					<div class="col-md-2 submit_button"> 
						<form action="details.html">
							<input type="submit" value="Search">
						</form>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>		
	<!-- banner -->
	<!-- hod -->
	<div class="hod">
		<div class="container">
			<div class="col-md-6 hod-left">
				<img src="img/yl_1.jpg" class="img-responsive" alt="">
			</div>
			<div class="col-md-6 hod-right">
				<h2><span id="h2_normal_sp1_bz"></span></h2>
				<p>
				明亮时尚的客房，宽敞的工作区提供有线和无线互联网连接，并配有充足的不间断电源和数据接口，
				逸林客房为您提供舒适的工作场所。透过全景的落地玻璃窗，精致的私家花园尽收眼底。宽敞的浴室，
				独立的浴缸与热带雨林淋浴设计组合让您如同在家般尽情地放松，唤醒您疲倦的身体。柔软的纯棉毛巾、
				高档的卫浴用品更让您倍感呵护。房间配有42寸高清电视，您可以躺在沙发上，冲一杯香浓咖啡，
				享受一个美妙之夜。希尔顿逸林甜梦之床将伴您安然入睡。 
				</p>
				<a class="hvr-shutter-in-horizontal" href="javascript:;">预订</a>
				
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- hod -->
    <div class="copyrights">Collect from <a href="http://www.tmooc.cn/" >BZ No.1</a></div>
	<!-- tels -->
	<div class="tels">
		<div class="container">
			<div class="col-md-4 tels-left">
				<h4><span id="h4_business1_sp1_bz"></span></h4>
				<img src="img/hy_01.jpg" class="img-responsive" alt="">
				<p>空间尤为宽敞的商务房中尽享宠爱自我的时光，面积最小60平米。
				华美城市景观令人惊叹，众多现代化设施与用品专为帮助您放松和保持高效而设，
				包括豪华睡床与床上用品，以及32英寸高清电视等。在宽敞的工作区通过高速网络轻松查阅电子邮件，
				在独立的起居区彻底放松，或在配有步入式雨林淋浴的雅致浴室里恢复身心活力。</p>
				<a class="hvr-shutter-in-horizontal" href="javascript:;">预订</a>
			</div>
			<div class="col-md-4 tels-left">
				<h4><span id="h4_luxury1_sp1_bz"></span></h4>
				<img src="img/hhf_01.jpg" class="img-responsive" alt="">
				<p>客房面积在29至32平米之间的豪华房，拥有迷人的城市景观。客房中提供免费有线与无线网络，
				您还能从手提电脑或任何移动设备上安全地进行远程打印。各种现代的设施与用品让您如同在家中一般方便，
				需要工作时也能保持高效专注。特大床配Serta Prefect Sleeper床垫，
				确保为您带来难忘的舒适体验。</p>
				<a class="hvr-shutter-in-horizontal" href="javascript:;">预订</a>
			</div>
			<div class="col-md-4 tels-left">
				<h4><span id="h4_flatlet1_sp1_bz"></span></h4>
				<img src="img/hj_03.jpg" class="img-responsive" alt="">
				<p>200平方米，室内摆设着水晶灯和闻名世界的品牌家具，运用世界前卫的装修技术，
				并含有古典中国元素。客房内木质地板、毛绒织品、还有庄重的色彩相互融合，
				装备的摩登便利设施及各种现代的用品会给您以家的感觉，另有独立厨房可以安排私密鸡尾酒聚会，
				让您享受难忘的尊贵住房体验。</p>
				<a class="hvr-shutter-in-horizontal" href="javascript:;">预订</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div>
		<%@include file="common/modal.jsp" %>
	</div>
	
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-2 deco">
				<h4>导航</h4>
				<li><a href="index.html">主页</a></li>
				<li><a href="shortcodes.html">XXX </a></li>
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