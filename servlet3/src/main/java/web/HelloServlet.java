package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			System.out.println(req.getContextPath());
			System.out.println(req.getServletPath());
			System.out.println(req.getRequestURI());
			System.out.println(req.getRequestURL());
			//本案例主要演示获取访问路径的方式
			//就不向浏览器输出内容，但服务器会自动
			//地向浏览器作出响应，只是内容为空而已，
			//浏览器看到一片空白的
	}

}
