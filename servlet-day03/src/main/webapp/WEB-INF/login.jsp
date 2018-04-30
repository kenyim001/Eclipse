
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>登录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
			
			
					<div id="header">
						<div id="rightheader">
							<p>
							<% 
								Date date=new Date();
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
								out.print(sdf.format(date));
							%>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
					
					
					
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						login
					</h1>
					<form action="login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">

						<tr>
							<td valign="middle" align="right">用户名:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="username" /></td>
						</tr>

						<tr>
							<td valign="middle" align="right">密&nbsp;&nbsp; 码:</td>
							<td valign="middle" align="left"><input type="password"
								class="inputgri" name="pwd" /></td>
						</tr>
						<tr>
							<td valign="middle" align="right">验证码:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="number" /> 
							</td>
						</tr>
						
						
						<tr>
							<td valign="middle" align="right"></td>
							<td valign="middle" align="left">
					<img src="checkcode.do"
								id="img1" />
								
							
								<a href="javascript:;"
								onclick="document.getElementById('img1').src='checkcode.do?'+Math.random();">看不清，换一个</a><br />
							</td> 
						</tr>
					</table>
						<p>
							<input type="submit" class="button" value="确认 &raquo;" />
							<span style="color:red;">
     		<% String msg= (String)request.getAttribute("login_failed");
     		String msg2=(String)request.getAttribute("number_error");	
     		out.print(msg2==null?"":msg2);
     		out.print(msg==null?"":msg);
     		%></span>
						</p>
					</form>
				</div>
			</div>
			
			<%@ include file="foot.jsp" %>
					</div>
	</body>
</html>
