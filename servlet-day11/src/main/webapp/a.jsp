<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
     	${1+1} <br/>
     	${"1"+"11"}<br/> 
     	${1<2}<br/> 
     	<%
     		request.setAttribute("s1", "abc");
     	%>
     		${$1=="abc"}
     		${5>3&&1>2 }<br/>	
     		<%List list1=new ArrayList();
     			request.setAttribute("list1", list1);
     			request.setAttribute("s2", "");
     		%>
     		空的集合：${empty list }<br/>	
     		空字符串：${empty s2 }<br/>	
     		null值：${empty null }<br/>
     		找不到对应的值：${empty abc }<br/>
     		
</body>
</html>