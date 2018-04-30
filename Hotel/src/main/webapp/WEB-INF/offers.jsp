<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Offers</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Motel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
<link href="css/style.css" rel='stylesheet' type='text/css'/>	
<link rel='stylesheet' type='text/css' href="css/offers.css" />
<link href="css/bootstrap-datepicker.min.css" rel='stylesheet' type='text/css'/>
<script src="js/jquery-1.11.1.min.js"></script>

<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<link rel='stylesheet' type='text/css' href="css/information_form.css" />
<script type="text/javascript" src="js/offers_load.js"></script>
<!-- <script type="text/javascript" src="js/offers.js"></script> -->
<script type="text/javascript" src="js/page.js"></script>
<script type="text/javascript" src="js/information_form.js"></script>	
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
								<li class="active"><a href="offersUI.do">优惠</a></li>
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
	</div>		
		<!-- banner -->
<!-- offers -->
	<div class="offers">
	
		<div class="container showoffers">
		
			<div class="col-md-4 offers-left">
				<div class="area">
					<h3 class="roomStyle">豪华房</h3>
					<div class="img">
						<p class="imgmsg">点击放大</p>
						<img src="offers_images/room/luxury/single.jpg" class="img-responsive" alt=""/>
					</div>
					<div>
						<div>
							<p>
								<span class="bedStyle">大床</span>：<span class="description">40平米 有窗 有wifi 单早</span>
							</p>
							<p class="pricearea">
								现在预订，只需￥<span class="price">299</span>
							</p>
						</div>
					</div>
				</div>
				<div>
					<input type="hidden" class="hidden_roomStyle" value=""/>
					<input type="hidden" class="hidden_bedStyle" value=""/>
					<input type="hidden" class="hidden_price" value=""/>
				</div>
				<a class="hvr-shutter-in-horizontal" href="javascript:;">预订</a>
			</div>
			
		</div>
			
		<div class="pages" id="pages">
			<span class="pageCurrent"></span>
			<a class="first">首页</a>
			<a class="pre">上一页</a>
			<span class="num"></span>
			<a class="next">下一页</a>
			<a class="last">尾页</a>
		</div>	
			
		<%@include file="common/modal.jsp" %>	
				
				
			<!-- 
			<div class="col-md-4 offers-left">
				<div class="area">
				<h3>豪华房</h3>
				<div class="img">
					<p class="imgmsg">点击放大</p>
					<img src="images/4.jpg" class="img-responsive" alt=""/>
				</div>
				<h4>大床房：32平米 有窗 有wifi 单早<br/>双床房：38平米 有窗 有wifi 双早</h4>
				<p>
					提前3天预订，可免费去健身房一天<br/>
					大床房原价￥499，现在预订，只需支付￥469<br/>
					双床房原价￥599，现在预订，只需支付￥569
				</p>
				</div>
				<a class="hvr-shutter-in-horizontal" href="details.html">预订</a>
			</div>
			<div class="col-md-4 offers-left">
				<div class="area">
				<h3>商务房</h3>
				<div class="img">
					<p class="imgmsg">点击放大</p>
					<img src="images/5.jpg" class="img-responsive" alt=""/>
				</div>
				<h4>大床房：35平米 有窗 有wifi 单早<br/>双床房：40平米 有窗 有wifi 双早</h4>
				<p>
					提前5天预订，可免费去游泳池一天<br/>
					大床房原价￥599，现在预订，只需支付￥569<br/>
					双床房原价￥699，现在预订，只需支付￥669
				</p>
				</div>
				<a class="hvr-shutter-in-horizontal" href="details.html">预订</a>
			</div>
			<div class="clearfix"></div>
			<div class="offer-btm">
				<div class="col-md-4 offers-left">
					<div class="area">
					<h3>贵宾房</h3>
					<div class="img">
						<p class="imgmsg">点击放大</p>
						<img src="images/2.jpg" class="img-responsive" alt=""/>
					</div>
					<h4>大床房：40平米 有窗 有wifi 单早<br/>双床房：50平米 有窗 有wifi 双早</h4>
					<p>
						可免费去健身房一天和游泳池一天<br/>
						大床房原价￥699，VIP只需支付￥669<br/>
						双床房原价￥799，VIP只需支付￥769
					</p>
					</div>
					<a class="hvr-shutter-in-horizontal" href="details.html">预订</a>
				</div>
				<div class="col-md-4 offers-left">
					<div class="area">
					<h3>会议厅</h3>
					<div class="img">
						<p class="imgmsg">点击放大</p>
						<img src="images/7.jpg" class="img-responsive" alt=""/>
					</div>
					<h4>可容纳20-30人，具有多媒体，投影，多声道功能</h4>
					<p>每小时</p>
					</div>
					<a class="hvr-shutter-in-horizontal" href="details.html">预订</a>
				</div>
				<div class="col-md-4 offers-left">
					<div class="area">
					<h3>宴会厅</h3>
					<div class="img">
						<p class="imgmsg">点击放大</p>
						<img src="images/8.jpg" class="img-responsive" alt=""/>
					</div>
					<h4>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</h4>
					<p>consectetuer adipiscing elit. Praesent vestibulum Lorem ipsum dolor sit amet, consectetuer adipiscing elit. molestie lacus.</p>
					</div>
					<a class="hvr-shutter-in-horizontal" href="details.html">预订</a>
				</div>
			</div>
			-->
		 
	</div>
<!-- offers -->
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-2 deco">
				<h4>导航</h4>
				<li><a href="index.html">主页</a></li>
				<li><a href="shortcodes.html">XXX</a></li>
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
	
	<!-- 放大图区域 -->
	<div class="picandbutton">
		<div class="showbigpic">
			<img id="bigpic" src=""/>
		</div>
		<div class="button">
			<img id="prevpic" class="btn" src="offers_images/fancy_nav_left.png"/>
			<img id="nextpic" class="btn" src="offers_images/fancy_nav_right.png"/>
			<img id="closepic" class="btn" src="offers_images/fancy_close.png"/>
		</div>
	</div>
	
	<div class="overbody"></div>
	
</body>
</html>