package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import dao.EmployeeDAO;
import entity.Employee;

public class LoadEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//读取要修改的员工的id
		String id=request.getParameter("id");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//依据id查询员工的信息
		EmployeeDAO dao=new EmployeeDAO();
		try {
			Employee emp=dao.findById(Integer.parseInt(id));
			/*		String name=emp.getName();
			int age=emp.getAge();
			double salary=emp.getSalary();
			//依据查询到的员工信息，生成修改页面
			out.println("<form action='modify' method='post'>");
			out.println("姓名： <input name='name' value='"+name+"'/><br/>");
			out.println("年龄： <input name='age' value='"+age+"'/><br/>");
			out.println("薪水： <input name='salary' value='"+salary+"'/><br/>");
			out.println("<input type='hidden' name='id' value='"+id+"'/>");
			out.println("<input type='submit' value='保存'/>");
			out.println("</form>");*/
			request.setAttribute("Employee", emp);
			RequestDispatcher rd=request.getRequestDispatcher("updateEmp.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
		out.close();
	}
}
