<%@ page import="java.util.Random"%>
<%@ page import=" java.util.*"%>
<%@ page import=" java.util.Set"%>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head></head>
<body>
<p style='color:red;'>
	<%
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; set.size() < 6; i++) {
			Random a = new Random();
			int b = a.nextInt(33) + 1;
			set.add(b);
		}
		out.print("红球：");
		for (int b : set)
			out.print(b+" ");
	%>
	</p>
	<p style='color:blue;'>
	<%
			out.print("蓝球：");
			Random a = new Random();
			int c = a.nextInt(16) + 1;
			out.print(c+" ");
			 %>
	</p>
</body>

</html>