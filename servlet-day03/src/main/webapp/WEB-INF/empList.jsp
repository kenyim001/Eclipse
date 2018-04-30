<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="entity.Employee,java.util.*"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<!-- 插入head.jsp -->
			<%@ include file="head.jsp"%>
			<div id="content">
				<p id="whereami"></p>
				<h1>员工列表</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>姓名</td>
						<td>薪水</td>
						<td>年龄</td>
						<td>操作</td>
					</tr>

					<!-- 		JAVA -->
		<%-- 			<%
						List<Employee> employess=(List<Employee>)request.getAttribute("employees");
						for(int i=0;i<employess.size();i++){
							Employee e=employess.get(i);
							%> 
							<tr class="row<%=(i%2+1)%>">
							<td>
							<%=e.getId()%>
							</td>
							<td>
								<%=e.getName()%>
							</td>
							<td>
								<%=e.getSalary()%>
							</td>
							<td>
								<%=e.getAge() %>
							</td>
								<td>
								<a href="del.do?id=<%=e.getId() %>" onclick="return confirm('确定删除<%=e.getName() %>吗？');">删除</a>&nbsp;<a href="load.do?id=<%=e.getId()%>">修改</a>
							</td>
						</tr>
							<%
						}
						%>  --%>
							 

					<!-- 		 标签加EL -->
					<c:forEach items="${employees }" var="u" varStatus="s">
						<tr class="row${s.index%2+1 }">
							<td>${u.id }</td>
							<td>${u.name }</td>
							<td>${u.salary }</td>
							<td>${u.age }</td>
							<td><a href="del.do?id=${u.id} "
								onclick="return confirm('确定删除${u.name}吗？');">删除</a>&nbsp;
								<a href="load.do?id=${u.id} ">修改</a></td>
						</tr>
					</c:forEach>
				</table>
				<p>
					<input type="button" class="button" value="添加员工"
						onclick="location='/toAdd.do'" />
				</p>
			</div>
		</div>
		<%@ include file="foot.jsp"%>
	</div>
</body>
</html>
