package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import entity.Employee;

public class addEmpServlet extends HttpServlet {
	

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String salary =  req.getParameter("salary");
		String p = req.getParameter("p");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//将员工信息插入到数据库
		EmployeeDao dao=new EmployeeDao();
		Employee emp=new Employee();
		emp.setName(name);
		emp.setSalary(Double.parseDouble(salary));
		emp.setAge(Integer.parseInt(age));
		try{
			dao.save(emp);
			out.println("添加成功");
		}catch(Exception e){
			e.printStackTrace();
			out.println("稍后再试");
		}
	
		out.println(name);
		out.println(age);
		out.println(salary);
		out.println(p);
		out.close();
	}
}
