package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class FindAllEmp extends HttpServlet{
	public void service(HttpServletRequest req,
			HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		EmployeeDAO dao=new EmployeeDAO();
		try{
		List<Employee> list=dao.findAll();
		req.setAttribute("emp", list);
		RequestDispatcher rd=req.getRequestDispatcher("empList.jsp");
		rd.forward(req, res);
		}catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
	}
}


