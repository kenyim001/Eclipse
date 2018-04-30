package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//首次调用session时服务器会自动给当前访问的浏览器创建一个session
		//该session是jsp不是的隐含对象之一
		String user=req.getParameter("user");
		//session中可以存任意类型的数据
		HttpSession session=req.getSession();
		session.setAttribute("user", user);
		//服务器响应时会作出如下处理
		//Cookie c =new Cookie("JSESSIONID",session.getId());
		//c.setPath(request.getContextPath());
		//response.addCookie(c);
		
	}
	
}
