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
		//调用genericServlet提供的getservletcontext方法获得上下文 
		ServletContext sctx=getServletContext();
		sctx.setAttribute("username", "小花");
		//调取全局的初始化参数
		String company=sctx.getInitParameter("company");
		System.out.println("company:"+company);
		
	}

}
