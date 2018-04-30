package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class b
 */
public class b extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ServletContext sc=getServletContext();
		String username=(String) sc.getAttribute("username");
		System.out.println("username"+username);
		ServletContext sctx=getServletContext();
		String company=sctx.getInitParameter("company");
		System.out.println("company:"+company);
	}
}
