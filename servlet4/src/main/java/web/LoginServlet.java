package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	//tomcat����Servlet�Ĺ���
	//loinServlet ls=new Loginservlet(); ʵ����
	//ServletConfig  cfg=new ServletConfig();
	//ls.init(cfg);  ��ʼ��
	//ls.service();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			ServletConfig cfg=getServletConfig();
			String maxOnline=cfg.getInitParameter("maxOnline");
			System.out.println(maxOnline);
	
	}
		
}
