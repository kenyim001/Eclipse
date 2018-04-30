
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*" %>
<html>
	<head></head>
	<body>
		<% 
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		out.print(sdf.format(date));
		%>
	</body>
</html>