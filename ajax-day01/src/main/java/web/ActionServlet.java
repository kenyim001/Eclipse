package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
	String uri=request.getRequestURI();
	String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
	System.out.println("action:"+action);
	if("/check".equals(action)){
		String uname=request.getParameter("uname");
		System.out.println("uname:"+uname);
			out.print("用户名占用");
		}else{
			out.print("可以使用");
		}
		
	}else if("/shownumber".equals(action)){
		int a=(int)(Math.random()*100);
		out.print(a);
	}else if("/getCity".equals(action)){
		String province=request.getParameter("province");
		System.out.println("province"+province);
		if("sd".equals(province)){
			out.println("jn:济南;qb:青岛");
		}else if("bj".equals(province)){
			out.println("cy:草原;qd:青岛;si:思想");
		}else if("/saveInfo".equals(action)){
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			System.out.println(name+":"+phone+":"+address);
			System.out.println("你的资料已保存");
		}else{
			out.println("cw:东京;yi:银座");
	
		}
	}
	}
}

