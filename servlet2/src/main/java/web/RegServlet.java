package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//���÷��������post������������
	req.setCharacterEncoding("utf-8");
		
		
		String name=req.getParameter("username");
		String pwd=req.getParameter("pwd");
		String sex=req.getParameter("sex");
		String [] interests=req.getParameterValues("interest");
		//���÷���һ�����������
//		byte[] bs=name.getBytes("iso8859-1");
//		name=new String(bs,"utf-8");
		
		//2.����ҵ��
		System.out.println(name);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests !=null){
			for(String interest : interests){
				System.out.println(interest);
			}
		}
	//3.������Ӧ
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter w=res.getWriter();
//		w.println("<p>ok,"+name+"</p>");
//		w.close();
		//�ض��򵽲�ѯҳ�棬���������������ȥ�ü��ҳ��
		//��ǰ��/EmpManaget/addEmp
		//Ŀ��: /EmpManaget/findEmp
		res.sendRedirect("findEmp");
	}
}