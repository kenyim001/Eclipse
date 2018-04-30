package web;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import entity.Employee;

public class findEmpservlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		//��ѯ������Ա������Ϣ
		EmployeeDao dao=new EmployeeDao();
		try{
		
		List<Employee> list=dao.findall();
		//���ݲ�ѯ����Ա����Ϣ��������
		out.println(
		"<table border='1' width='60%' cellpadding='0' cellspacing='0'>");
		out.print("<tr><td>ID</td><td>����</td><td>нˮ</td><td>����</td></tr>");
		for(int i=0;i< list.size();i++){
			Employee e=list.get(i);
			out.println(
					"<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td> "
					+ "<td>"+e.getSalary()+"</td>"
					+ "<td>"+e.getAge()+"</td>"
					+ "</tr>"
					);
		}
		out.println("</table>");
		}catch(Exception e){
			e.printStackTrace();
			out.println("�Ժ�����");
		}
	}
}
