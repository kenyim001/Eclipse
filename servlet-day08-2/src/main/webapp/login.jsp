<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
     <form action="login.do" method="post">
     <fieldset>
     		<legend>登录</legend>
     		用户名：<input name="username"/><br/>
     		密 &nbsp;&nbsp; 码：<input type="password" name="pwd">
     		<%
     			String msg2=(String)request.getAttribute("number_error");	
     		%>
     		<span style="color:red;"><%=(msg2==null?"":msg2) %></span><br/>
     		验证码:<input name="number" />
     		<img  src="checkcode"  id="img1" /><a href="javascript:;" onclick="document.getElementById('img1').src='checkcode?'+Math.random();">看不清，换一个</a><br/>
     		<input type="submit" value="确认"><span style="color:red;">
     		<% String msg= (String)request.getAttribute("login_failed");
     		out.print(msg2==null?"":msg2);
     		out.print(msg==null?"":msg);
     		%></span>
 
     </fieldset>
         </form>
</body>
</html>