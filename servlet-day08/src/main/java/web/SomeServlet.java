package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet extends HttpServlet {
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		//获取session对象
		HttpSession session=request.getSession(true);
		String sessionId=session.getId();
		System.out.println("sessionId:"+sessionId);
		HttpSession s=request.getSession();
//		等于HttpSession session=request.getSession(true);
		Integer count=(Integer) session.getAttribute("count");
		session.setMaxInactiveInterval(20);
		if(count==null){
			//第一次
			count=1;
		}else{
			//不是第一次
			count ++;
		}
		session.setAttribute("count", count);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("你系第"+count+"次访问了，你到底想点");
		//删除session
//		session.invalidate();
	}
		
}
