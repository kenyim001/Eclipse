<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charse="utf-8" />
<title>第一个JSP</title>
</head>
<body>
	<!-- 3.jsp声明 -->
	<%! 
			     public double bai(double d){
				return d*100;
			}
			%>
	<ul>
		<!-- 1.jsp脚本 -->
		<%
					for(int i=0;i<10;i++){
					%>
		<!-- 2.jsp表达式 -->
		<li><%=bai(Math.random())  %></li>

		<%	
					}
			%>
	</ul>
	<%@include file="time.jsp"%>
</body>
</html>