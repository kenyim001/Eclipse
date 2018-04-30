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
			
		//1.���ղ���
		res.setCharacterEncoding("utf-8");
		String ename=req.getParameter("ename");
		String job=req.getParameter("job");
		String sal=req.getParameter("sal");
		
		//2.����Ա������
		Emp e=new Emp();
		e.setEname(ename);
		e.setJob(job);
		e.setSal(Double.valueOf(sal));
		new EmpDao().save(e);
		
		//3.������Ӧ
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out=res.getWriter();
//		out.println("<b>����ɹ�</b>");
//		out.close();
		//�ض��򵽲�ѯҳ�棬��������������ѷ��ʲ�ѯҳ��
			res.sendRedirect("findEmp");

	}
}
