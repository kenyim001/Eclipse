package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
@Controller
public class HelloController {
	@ExceptionHandler
	/**
	 * �쳣������
	 * ���������ķ����������쳣�ͻ�����쳣������������
	 * ע��e
	 * �������������׳����쳣
	 * @return
	 */
	public String handle(Exception e,HttpServletRequest req){
		//�����쳣�����ͣ�����ͬ�Ĵ���
		if(e instanceof NumberFormatException){
			req.setAttribute("msg", "�����ְ�");
			return "error3";
		}else if(e instanceof StringIndexOutOfBoundsException){
			req.setAttribute("msg", "Խ�簡");
			return "error3";
		}
		return "error";
	}
	
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		Integer.parseInt("123a");
		return "hello"; 
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2()");
		String str="abcd";
		str.charAt(10);
		return "hello";
	}
}
