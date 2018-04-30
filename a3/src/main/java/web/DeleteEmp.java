package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;

public class DeleteEmp extends HttpServlet{
		public void service(HttpServletRequest req,
				HttpServletResponse res)throws ServletException,IOException{
				res.setContentType("text/html;charset=utf-8");
				PrintWriter out=res.getWriter();
				EmployeeDAO dao=new EmployeeDAO();
				try {
					int id=Integer.parseInt(req.getParameter("id"));
					dao.delete(id);
					res.sendRedirect("list");
				} catch (Exception e) {
					e.printStackTrace();
					out.println("Ê§°Ü");
				}
		}
}
