package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//采用方案三解决post请求乱码问题
	req.setCharacterEncoding("utf-8");
		
		
		String name=req.getParameter("username");
		String pwd=req.getParameter("pwd");
		String sex=req.getParameter("sex");
		String [] interests=req.getParameterValues("interest");
		//采用方案一解决乱码问题
//		byte[] bs=name.getBytes("iso8859-1");
//		name=new String(bs,"utf-8");
		
		//2.处理业务
		System.out.println(name);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests !=null){
			for(String interest : interests){
				System.out.println(interest);
			}
		}
	//3.发送响应
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter w=res.getWriter();
//		w.println("<p>ok,"+name+"</p>");
//		w.close();
		//重定向到查询页面，即建议浏览器自已去访间查页面
		//当前：/EmpManaget/addEmp
		//目标: /EmpManaget/findEmp
		res.sendRedirect("findEmp");
	}
}