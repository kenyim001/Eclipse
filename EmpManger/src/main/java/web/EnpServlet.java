package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

/*
 * �����淶��
 * ��ѯԱ����/find.emp
 * ����Ա����/add.emp
 * 
 * */

public class EnpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//�жϷ���·������������
		String path=req.getServletPath();
		if("/find.emp".equals(path)){
			findEmp(req,res);
		}else if("/add.emp".equals(path)){
			addEmp(req,res);
		}else{
			throw new RuntimeException("���޴�ҳ");
		}
	}



	protected void findEmp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.���ղ���
		//2.����ҵ��
		EmpDao dao=new EmpDao();
		List<Emp> list=dao.findAll();
		//3.������Ӧ
		res.setContentType("text/html;charset=utf-8");
		PrintWriter w=res.getWriter();
		//��ǰ��/EmpManger/findEmp
		//Ŀ�꣺/EmpManger/add_emp.html
		w.println("<a href='add_emp.html'>����</a>");
		w.println("<table border='1' cellspacing='0' width='30%'>");
		
		w.println("<tr>");
		w.println("       <td>���</td>");
		w.println("       <td>����</td>");
		w.println("       <td>ְλ</td>");
		w.println("       <td>н��</td>");
		w.println("</tr>");
		if(list !=null){
			for(Emp e:list){
				w.println("<tr>");
				w.println("	<td>"+e.getEmpno()+"</td>");
				w.println("	<td>"+e.getEname()+"</td>");
				w.println("	<td>"+e.getJob()+"</td>");
				w.println("	<td>"+e.getSal()+"</td>");
				w.println("</tr>");
			}
		}
		w.println("</table>");
		w.close();
	}



	
	protected void addEmp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
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
			res.sendRedirect("find.emp");

	}

	
	
	
	
}
