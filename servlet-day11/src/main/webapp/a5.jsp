<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="bean.*,java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
		.row1{
			background-color:#f0f0f0;
		}
		.row2{
			background-color:#fff8dc;
		}	
	</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
     <%
     	List<User> users=new ArrayList<User>();
     	for(int i=0;i<8;i++){
     		User user=new User();
     		user.setName("user0"+i);
     		user.setGender("m");
     		user.setAge(22+i);
     		users.add(user);
     	}
     	request.setAttribute("users", users);
     %>
     
     <table border="1" width="60%" cellpadding="0" cellspacing="0">
		<tr>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>下标</td>
			<td>序号</td>
		</tr>
		<c:forEach items="${users }" var="u" varStatus="s">
			<tr class="row${s.index%2+1} ">
				<td>${u.name }</td>
				<td>${u.age }</td>
				<td>${u.gender }</td>
				<td>${s.index }</td>
				<td>${s.count }</td>
			</tr>
		</c:forEach>
	</table>
     
     
</body>
</html>