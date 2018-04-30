package cn.tedu.ems.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.ApplicationException;
import cn.tedu.ems.service.LoginService;

@Controller
public class LoginController {
	@ExceptionHandler
	public String handle(Exception e,HttpServletRequest req){
		System.out.println("heandle");
		if(e instanceof ApplicationException){
			req.setAttribute("login_failed", e.getMessage());
			return "login";
		}
		return "error";
	}
	
	@RequestMapping("/checkcode.do")
	//输出验证码图片
	public void checkcode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("checkcode...");
		/**
		 * step1����ͼƬ
		 */
		//����һ������
			BufferedImage img=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//��û���
			Graphics g=img.getGraphics();
			//����������ɫ
			g.setColor(new Color(255, 255, 255));
			//���û���������ɫ��Χ
			g.fillRect(0, 0, 80, 30);
			//����������ɫ
			Random  r=new Random();
			g.setColor(new Color(
					r.nextInt(255), 
					r.nextInt(255), 
					r.nextInt(255)));
			//��������
			g.setFont(new Font(null,Font.BOLD,24));
			//����һ�������
			String number=getNumber(5);
			//��ͼƬ�ϻ��������
			g.drawString(number, 2, 25);//���½�����
			
			//��
			HttpSession session=request.getSession();
			session.setAttribute("number",number);
			
			//������
			for (int i = 0; i < 8; i++) {
				g.setColor(new Color(
    					r.nextInt(255), 
    					r.nextInt(255), 
    					r.nextInt(255)));
				g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), 30);
			}
			
		/**
		 * step2 ѹ��ͼƬ�����jpeg
		 */
			//��������������������ص���һ��ͼƬ
			response.setContentType("image/jpeg");
			//Ҫ����ֽ������
			OutputStream output=response.getOutputStream();
			//��ԭʼͼƬ����ָ���ĸ�ʽ ��jpeg������ѹ����Ȼ�����
			javax.imageio.ImageIO.write(img, "jpeg", output);
			output.close();
			
}
	
	
	public String getNumber(int size){
		String chars="ABCDEFGHIJKLNMOPQRSTUVWYZ"
				+ "0123456789";
		String number="";
		Random r=new Random();
		for (int i = 0; i < size; i++) {
			number+=chars.charAt(r.nextInt(chars.length()));
		}
		return number;
	}
	
	@Resource(name="loginService")
	private LoginService ls;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request,HttpSession session){
		System.out.println("login()");
		String username = 
				request.getParameter("username");
		String pwd = 
				request.getParameter("pwd");
		System.out.println(username+ " "
				+ pwd);
		
		//将请求分发给业务层来处理
		
		/*try{*/
			User user = 	ls.checkLogin(	username, pwd);	
			//登录成功，将user对象绑订到session上
			session.setAttribute("user", user);
	/*	}catch(Exception e){
			e.printStackTrace();
			//依据异常类型，分别做不同的处理
			if(e instanceof 
					ApplicationException){
				//应用异常，应明确提示用户
				request.setAttribute(
						"login_failed",
						e.getMessage());
				return "login";
			}
			//系统异常，提示用户稍后重试
			return "error";
		}*/
		//登录成功
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	
}





