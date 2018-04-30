package cn.tedu.ems.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.tedu.ems.servicce.ApplicationException;
import cn.tedu.ems.servicce.LoginService;

/**
 * 处理器类
 * 1.不用实现Controller接口
 * 2.可以添加多个方法
 * 3.方法名不做要求，返回类型可以是ModelAndView,也可以是String
 * 4.方法前面可以添加@RequestMapping注解
 * 注：该注解作用相当于HandlerMapping,另外该注解也可以添加到类前面
 * 处理：http://"ip:port/spring-day04/hello.do"的请求
 * 															/demo/hello.do
 * 5.在类前面添加@Contrtoller相当于@Component
 * 注：该注解用于组件扫描
 * @author kenyim
 *
 */
//	@RequestMapping("/demo")
@Controller
public class HelloController {
	@RequestMapping("/hello.do")
		public String hello(){
			System.out.println("hello()");
			//返回视图名
			return "hello";
		}
 
	@RequestMapping("/tobmi.do")
	public String tobmi(){
		System.out.println("tobmi()");
		//返回视图名
		return "tobmi";
	}
	@RequestMapping("/bmi.do")
	/**
	 * (了解)DispatcherServlet在调用处理器的方法之前会利用java反射分析
	 * 方法的结构，比如这里，会将request对象作为参数传进来。
	 */
	
	public String bmi(HttpServletRequest req){
		System.out.println("bmi()");
		String height=req.getParameter("height");
		String weight=req.getParameter("weight");
		System.out.println(height+" "+weight);
		//返回视图名l
		return "view";
	}	
	
	//参数比较少
	@RequestMapping("/bmi2.do")
		public String bmi2(
				@RequestParam("height")String ht,String weight){
			System.out.println("bmi2()");
			System.out.println(ht+" "+weight);
			return "view";
		}
		
	//适用多参数
		@RequestMapping("/bmi3.do")
		public String bmi3(Bmiparam bp){
			System.out.println("bmi3()");
			System.out.println(bp.getHeight()+" "+bp.getHeight());
			return "view";
		}
	
		//适用多参数
		@RequestMapping("/bmi4.do")
		public String bmi4(Bmiparam bp,HttpServletRequest req){
			System.out.println("bmi4()");
			
			double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
			String status="正常";
			if(bmi<19){
				status="过轻";
			}if(bmi>25){
				status="过重";
			}
			//	将数据数据绑定到req对象
			req.setAttribute("status", status);
			//DispatcherServlet默认会使用转发
			return "view";
		}
		
		@RequestMapping("/bmi5.do")
		public ModelAndView Bmi5(Bmiparam bp){
			System.out.println("bmi5()");
			double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
			String status="正常";
			if(bmi<19){
				status="过轻";
			}if(bmi>25){
				status="过重";
			}
			//将数据放到ModelAndView 对象里面
			Map<String,Object> data=new HashMap<String,Object>();
			//相当于request.setAttribute
			data.put("status", status);
			ModelAndView mav=new ModelAndView("view",data);
			return mav;
		}	
		
		@RequestMapping("/bmi6.do")
		public String bmi6(Bmiparam bp,ModelMap mm){
			System.out.println("bmi6()");
			double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
			String status="正常";
			if(bmi<19){
				status="过轻";
			}if(bmi>25){
				status="过重";
			}
			//将数据添加到ModelMap对象
				mm.addAttribute("status", status);
			return "view";
		}
		
		@RequestMapping("/bmi7.do")
		public String bmi7(Bmiparam bp,HttpSession session){
			System.out.println("bmi7()");

			double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
			String status="正常";
			if(bmi<19){
				status="过轻";
			}if(bmi>25){
				status="过重";
			}
			//将数据绑订到 session对象上
			session.setAttribute("status", status);
			return "view";
		}
		
		/*
		@RequestMapping("/index.do")
		public String login(HttpServletRequest req){
			System.out.println("login()");
			//将请求分发给业务层来处理
			String username=req.getParameter("username");
			String pwd=req.getParameter("pwd");
			try{
				 User user=ls.checkLogin(username,pwd);
			}catch (Exception e) {
				e.printStackTrace();
				if(e instanceof ApplicationException){
					//应用异常，应明确提示用户
					req.setAttribute("login_faild", e.getMessage());
					return "login";
				}//系统异常，提示用户稍后再试
				 return "error";
			}
			return "redirect:toIndex.do";
			
		}
		
		@RequestMapping("/tologin.do")
		public String login(){
			System.out.println("login()");
			//返回视图名
			return "login";
		}
		
		@RequestMapping("/toIndex.do")
		public String toIndex(){
			return "index";
		}
	
		@Resource(name="loginService")
		private LoginService ls;*/
}	

