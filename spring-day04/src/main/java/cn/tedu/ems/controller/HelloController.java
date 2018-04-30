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
 * ��������
 * 1.����ʵ��Controller�ӿ�
 * 2.������Ӷ������
 * 3.����������Ҫ�󣬷������Ϳ�����ModelAndView,Ҳ������String
 * 4.����ǰ��������@RequestMappingע��
 * ע����ע�������൱��HandlerMapping,�����ע��Ҳ������ӵ���ǰ��
 * ����http://"ip:port/spring-day04/hello.do"������
 * 															/demo/hello.do
 * 5.����ǰ�����@Contrtoller�൱��@Component
 * ע����ע���������ɨ��
 * @author kenyim
 *
 */
//	@RequestMapping("/demo")
@Controller
public class HelloController {
	@RequestMapping("/hello.do")
		public String hello(){
			System.out.println("hello()");
			//������ͼ��
			return "hello";
		}
 
	@RequestMapping("/tobmi.do")
	public String tobmi(){
		System.out.println("tobmi()");
		//������ͼ��
		return "tobmi";
	}
	@RequestMapping("/bmi.do")
	/**
	 * (�˽�)DispatcherServlet�ڵ��ô������ķ���֮ǰ������java�������
	 * �����Ľṹ����������Ὣrequest������Ϊ������������
	 */
	
	public String bmi(HttpServletRequest req){
		System.out.println("bmi()");
		String height=req.getParameter("height");
		String weight=req.getParameter("weight");
		System.out.println(height+" "+weight);
		//������ͼ��l
		return "view";
	}	
	
	//�����Ƚ���
	@RequestMapping("/bmi2.do")
		public String bmi2(
				@RequestParam("height")String ht,String weight){
			System.out.println("bmi2()");
			System.out.println(ht+" "+weight);
			return "view";
		}
		
	//���ö����
		@RequestMapping("/bmi3.do")
		public String bmi3(Bmiparam bp){
			System.out.println("bmi3()");
			System.out.println(bp.getHeight()+" "+bp.getHeight());
			return "view";
		}
	
		//���ö����
		@RequestMapping("/bmi4.do")
		public String bmi4(Bmiparam bp,HttpServletRequest req){
			System.out.println("bmi4()");
			
			double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
			String status="����";
			if(bmi<19){
				status="����";
			}if(bmi>25){
				status="����";
			}
			//	���������ݰ󶨵�req����
			req.setAttribute("status", status);
			//DispatcherServletĬ�ϻ�ʹ��ת��
			return "view";
		}
		
		@RequestMapping("/bmi5.do")
		public ModelAndView Bmi5(Bmiparam bp){
			System.out.println("bmi5()");
			double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
			String status="����";
			if(bmi<19){
				status="����";
			}if(bmi>25){
				status="����";
			}
			//�����ݷŵ�ModelAndView ��������
			Map<String,Object> data=new HashMap<String,Object>();
			//�൱��request.setAttribute
			data.put("status", status);
			ModelAndView mav=new ModelAndView("view",data);
			return mav;
		}	
		
		@RequestMapping("/bmi6.do")
		public String bmi6(Bmiparam bp,ModelMap mm){
			System.out.println("bmi6()");
			double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
			String status="����";
			if(bmi<19){
				status="����";
			}if(bmi>25){
				status="����";
			}
			//��������ӵ�ModelMap����
				mm.addAttribute("status", status);
			return "view";
		}
		
		@RequestMapping("/bmi7.do")
		public String bmi7(Bmiparam bp,HttpSession session){
			System.out.println("bmi7()");

			double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
			String status="����";
			if(bmi<19){
				status="����";
			}if(bmi>25){
				status="����";
			}
			//�����ݰ󶩵� session������
			session.setAttribute("status", status);
			return "view";
		}
		
		/*
		@RequestMapping("/index.do")
		public String login(HttpServletRequest req){
			System.out.println("login()");
			//������ַ���ҵ���������
			String username=req.getParameter("username");
			String pwd=req.getParameter("pwd");
			try{
				 User user=ls.checkLogin(username,pwd);
			}catch (Exception e) {
				e.printStackTrace();
				if(e instanceof ApplicationException){
					//Ӧ���쳣��Ӧ��ȷ��ʾ�û�
					req.setAttribute("login_faild", e.getMessage());
					return "login";
				}//ϵͳ�쳣����ʾ�û��Ժ�����
				 return "error";
			}
			return "redirect:toIndex.do";
			
		}
		
		@RequestMapping("/tologin.do")
		public String login(){
			System.out.println("login()");
			//������ͼ��
			return "login";
		}
		
		@RequestMapping("/toIndex.do")
		public String toIndex(){
			return "index";
		}
	
		@Resource(name="loginService")
		private LoginService ls;*/
}	

