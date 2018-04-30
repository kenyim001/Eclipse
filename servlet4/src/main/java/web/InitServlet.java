package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
/*
 * 此类仅仅是地服务器启动时初始化参数的不负责
 * 处理
 * 
 * */
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx=getServletContext();
		ctx.setAttribute("count", 0);
		Integer count=(Integer)ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		System.out.println(count);
	}
	
}
