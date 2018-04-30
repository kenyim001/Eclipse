package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * Servlet implementation class SomeServlet
 */
public class SomeServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("username"+username);
//		response.sendRedirect(request.getContextPath()+"/biz03/sub/aaa.jsp");  重定向 要项目名开始 
		
		request.getRequestDispatcher("/biz03/sub/aaa.jsp").forward(request, response);//转发 从项目名下一级开始写
		
		
	}

}
