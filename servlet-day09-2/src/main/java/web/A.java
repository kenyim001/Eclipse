package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

public class A extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//����genericServlet�ṩ��getservletcontext������������� 
		ServletContext sctx=getServletContext();
		sctx.setAttribute("username", "С��");
		//��ȡȫ�ֵĳ�ʼ������
		String company=sctx.getInitParameter("company");
		System.out.println("company:"+company);
		
	}

}
