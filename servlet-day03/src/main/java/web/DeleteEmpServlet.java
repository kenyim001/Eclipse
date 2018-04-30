package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;

public class DeleteEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String id=request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		EmployeeDAO dao=new EmployeeDAO();
		try {
			dao.delete(Integer.parseInt(id));
			//重定向到员工列表
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("系统繁忙，稍后重试");
		}
		out.close();
	}
}
