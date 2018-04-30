<%@page import="java.util.List,entity.*"%>
<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//tW3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<style type="text/css">
		.row1{
				background-color:#fff8dc; 
		}
		.row2{
				background-color: #f0f0f0;
		}
	</style>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<table border="1" width="60%" cellpadding="0" cellspacing="0">
		<tr >
				<td>ID</td><td>姓名</td>
				<td>薪水</td><td>年龄</td>
		</tr>	
	<%
			EmployeeDAO dao=new EmployeeDAO();
			List<Employee> employees=dao.findAll();
			for(int i=0;i<employees.size();i++){
				Employee e=employees.get(i);
				%>
				<tr class="row<%=(i % 2+1)%>">
					<td><%=e.getId()%></td><td><%=e.getName()%></td>
					<td><%=e.getSalary() %></td><td><%=e.getAge() %></td>
				</tr>	
				<% 
			}
			
	%>
	</table>
</body>
</html>