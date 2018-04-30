<%-- <%@ page import="dao.EmployeeDAO"%>
<%@ page import="entity.Employee,java.util.*"%> --%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>员工管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						2009/11/20 <br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>员工列表</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>年龄</td>
						<td>工薪</td>
						<td>年龄</td>
						<td>操作</td>
					</tr>

					<c:forEach items="${emp }" var="u" varStatus="s">
						<tr class="row${s.index%2+1 }">
							<td>${u.id }</td>
							<td>${u.name }</td>
							<td>${u.salary}</td>
							<td>${u.age}</td>
							<td><a href="delete?id=${u.id}"
								onclick="return confirm('确定删除${u.name}吗？');">删除</a>&nbsp;<a
								href="load?id=${u.id}">修改</a></td>
						</tr>
					</c:forEach>
				</table>
				<p>
					<input type="button" class="button" value="Add Employee"
						onclick="location='addEmp.jsp'" />
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>
