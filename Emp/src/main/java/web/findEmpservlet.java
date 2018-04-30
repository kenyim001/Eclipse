package web;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import entity.Employee;

public class findEmpservlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		//查询出所有员工的信息
		EmployeeDao dao=new EmployeeDao();
		try{
		
		List<Employee> list=dao.findall();
		//依据查询到的员工信息，输出表格
		out.println(
		"<table border='1' width='60%' cellpadding='0' cellspacing='0'>");
		out.print("<tr><td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td></tr>");
		for(int i=0;i< list.size();i++){
			Employee e=list.get(i);
			out.println(
					"<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td> "
					+ "<td>"+e.getSalary()+"</td>"
					+ "<td>"+e.getAge()+"</td>"
					+ "</tr>"
					);
		}
		out.println("</table>");
		}catch(Exception e){
			e.printStackTrace();
			out.println("稍后再试");
		}
	}
}
