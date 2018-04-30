package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ModifyEmpServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");//设置字符集
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//读取员工信息
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		double salary=Double.parseDouble(request.getParameter("salary"));
		Employee emp=new Employee(id, name, salary, age);
		
		//修改员工信息
		EmployeeDAO dao=new EmployeeDAO();
		try {
			dao.modify(emp);
			response.sendRedirect("list");//重定向list页面
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
		out.close();
	}
}
