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
		//分析请求资源路径
		 String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		 //依据分析结果，调用不同的分支不处理
		 if("/list".equals(action)){
			 System.out.println("处理list请求");
		 }else if("/add".equals(action)){
			 System.out.println("处理add请求");
		 }
			 
	}
}
