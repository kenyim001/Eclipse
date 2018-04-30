<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="entity.Employee,java.util.*"%>
<%@ taglib uri="test" prefix="c1" %>




     	<div id="header">
					<div id="rightheader">
		<%
						//进行session验证
						Object obj = session.getAttribute("user");
						
						if (obj == null) {
							response.sendRedirect("login.jsp");
							return;
						}
					%> 
							<!-- 单击退出删除session -->
					<p id="logout"> 
				<%-- 	<%
						日期
						Date date=new Date();
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						out.print(sdf.format(date));
						%>		  --%>
						<c1:date pattern="yyyy-MM-dd"/>
						
						
						
								<a  href="logout.do">退出</a>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
