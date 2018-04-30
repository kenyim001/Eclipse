package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class AddEmp extends HttpServlet{
	public void service(HttpServletRequest req,
			HttpServletResponse res)throws ServletException,IOException{
			res.setCharacterEncoding("utf-8");
			
			String name=req.getParameter("name");
			String salary=req.getParameter("salary");
			String age=req.getParameter("age");
			
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			
			EmployeeDAO dao=new EmployeeDAO();
			Employee emp=new Employee();
			emp.setName(name);
			emp.setSalary(Double.parseDouble(salary));
			emp.setAge(Integer.parseInt(age));
			try {
				dao.save(emp);
				res.sendRedirect("list");
			} catch (Exception e2) {
				e2.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
	}
}
