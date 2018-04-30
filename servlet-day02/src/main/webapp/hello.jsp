<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		current time:
		<%
			Date date=new Date();
			out.println(date);
		%>
		<%=new Date()%>
	
	
		<%
			for(int i=0;i<100;i++){%>
				<%=("<h1>hello 1111</h1>")%>
		<%	}
		%>
	</body>
</html>