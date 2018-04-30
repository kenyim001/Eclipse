package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
		public void service(
				HttpServletRequest request,
				HttpServletResponse response)
		throws ServletException,IOException{
			//设置服务器返回的数据类型
			response.setContentType("text/html");
			//获得一个输出流
			String name=request.getParameter("name");
			PrintWriter out=response.getWriter();
			//输出数据（即发送给浏览器）
			out.println("<h1>"+name+"</h1>");
			out.close();
		}
}
