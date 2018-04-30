package cn.tedu.hotel.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.hotel.entity.User;
import cn.tedu.hotel.service.ApplicationException;
import cn.tedu.hotel.service.UserService;




@Controller
public class UserController {
	
	@ExceptionHandler
	public String handler(Exception e,HttpServletRequest request){
		if(e instanceof ApplicationException){
			request.setAttribute("login_failed", e.getMessage());
			return "login";
		}
		return "error";
	}
	
	@Resource(name="service")
	private UserService us; 
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		
		return "login";
	}
	@RequestMapping("/Login.do")
	public String login(HttpServletRequest request,HttpSession session){
		String tel = request.getParameter("tel");
		String password = request.getParameter("password");
		System.out.println(tel);
		System.out.println(password);
		User user = us.checkLogin(tel, password);
		session.setAttribute("user",user);
		return "redirect:index.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/index.do")
	public String onToIndex(){
		return "index";
	}
	@RequestMapping("/toUpdate.do")
	public String toUpdate(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		request.setAttribute("load",user);
		return "Update";
	}
	
	@RequestMapping("/modify.do")
	public String toModify(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws UnsupportedEncodingException{
		System.out.println("modify");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		user.setName(request.getParameter("name"));
		user.setGender(request.getParameter("gender"));
		user.setEmail(request.getParameter("email"));
		user.setAccountNumber(request.getParameter("accountNumber"));
		user.setPassword(request.getParameter("password"));
		System.out.println(user);
		us.modifyUser(user);
		System.out.println("modifyUser");
		session.setAttribute("user",user);
		return "index";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.setAttribute("user", null);
		return "index";
	}
}
