package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

public class ActionServlet extends HttpServlet {
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//处理中文 
		request.setCharacterEncoding("utf-8");
		//获得请求资源路径
		String uri=request.getRequestURI();
		String action=uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		if("/login".equals(action)){
			/**
			 * 先比较验证码是否正确
			 * 如果验证码不正确，不再比较用户名和密码
			 */
			//用户提交过来的验证码
			String number1=request.getParameter("number").toUpperCase();
			//session对象上事先绑订的验证码
			HttpSession session=request.getSession();
			String number2=(String) session.getAttribute("number");
			if(!number1.equals(number2)){
				request.setAttribute("number_error", "验证码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			//读取用户名和密码
			String username=request.getParameter("username");
			String pwd=request.getParameter("pwd");
			System.out.println("username:"+username+"pwd:"+pwd);
			//查询数据库
			UserDao dao=new UserDao();
			try {
				User user=dao.findByUsername(username);
				if(user !=null&&
						user.getPwd().equals(pwd)){
					//登陆成功
					session.setAttribute("user", user);
					response.sendRedirect("index.jsp");
					
				}else{
					//登陆失败
					request.setAttribute("login_failed", "用户名或密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		
	}

}
