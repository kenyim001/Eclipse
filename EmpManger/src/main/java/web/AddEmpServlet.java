package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		//1.接收参数
		res.setCharacterEncoding("utf-8");
		String ename=req.getParameter("ename");
		String job=req.getParameter("job");
		String sal=req.getParameter("sal");
		
		//2.保存员工数据
		Emp e=new Emp();
		e.setEname(ename);
		e.setJob(job);
		e.setSal(Double.valueOf(sal));
		new EmpDao().save(e);
		
		//3.发送响应
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out=res.getWriter();
//		out.println("<b>保存成功</b>");
//		out.close();
		//重定向到查询页面，即建议浏览器自已访问查询页面
			res.sendRedirect("findEmp");

	}
}
