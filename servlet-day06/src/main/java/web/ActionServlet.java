package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	System.out.println("ActionServlet's service()");
		String uri=req.getRequestURI();
		System.out.println(uri);
		//����������Դ·��
		 String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		 //���ݷ�����������ò�ͬ�ķ�֧������
		 if("/list".equals(action)){
			 System.out.println("����list����");
		 }else if("/add".equals(action)){
			 System.out.println("����add����");
		 }
			 
	}
}
