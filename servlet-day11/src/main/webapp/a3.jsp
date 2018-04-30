<%@page import="bean.User"%>
<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
     <%
     	User user=new User();
     user.setName("李白");
     user.setGender("x");
     request.setAttribute("user", user);
     %>
     姓名：${user.name }<br/>
     性别：<c:if test="${user.gender=='m' }">男</c:if>
     				<c:if test="${user.gender=='f' }">女</c:if>
     				<br/>
      性别：<c:if test="${user.gender=='m' }">男</c:if>
     				<c:if test="${user.gender!='m' }">女</c:if>
     				<br/>		
     	性别：<c:if test="${user.gender=='m' }" var="rs" scope="request">男</c:if>		
    			 	<%-- 	<% request.getAttribute("rs",flase)%> --%>
     				<c:if test="${!rs }">女</c:if>
     		性别：
     				
</body>
</html>