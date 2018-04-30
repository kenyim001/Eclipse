package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import dao.EmployeeDAO;
import entity.Employee;

public class FindAllEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String ip=request.getRemoteHost();
		System.out.println("ip:"+ip);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		EmployeeDAO dao=new EmployeeDAO();
		try {
			List<Employee> list=dao.findAll();
		/*	out.println("<table border='1' width='60%' cellpadding='0' cellspacing='0'>");
			out.println("<tr><td>ID</td><td>姓名</td><td>年龄</td><td>薪水</td><td>操作</td></tr>");
			for(Employee emp:list){
				int id=emp.getId();
				String name=emp.getName();
				int age=emp.getAge();
				double salary=emp.getSalary();
				out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+salary+"</td><td><a href='del?id="+id+"'>删除</a>&nbsp;<a href='load?id="+id+"'>修改</a></td></tr>");
			}
			out.println("</table>");
			out.println("<a href='addEmp.html'>添加员工</a>");*/
			//依据查询到的员工信息，输出表格
			 //因为servlet不方便输出，所以
			//转发给listemp3.jsp来生成表格、
			
			//setp1.将数据绑定request对象上
			request.setAttribute("employees", list);
			//step2.获得转发器
			RequestDispatcher rd=request.getRequestDispatcher("empList.jsp");
			//step3转发
			rd.forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
		out.close();
	}
}
