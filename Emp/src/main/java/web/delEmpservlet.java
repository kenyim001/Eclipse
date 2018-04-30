/*package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import entity.Employee;

public class delEmpservlet extends HttpServlet{
		public void service(HttpServletRequest req,HttpServletResponse res)
		throws ServerException,IOException{
			Integer id=Integer.parseInt(req.getParameter("id"));
			EmployeeDao dao=new EmployeeDao();
			PrintWriter out=res.getWriter();
	try {
		dao.del(id);
	} catch (Exception e) {
	e.printStackTrace();
	out.println("ит╨Стыйт");
	}
		}
}
*/