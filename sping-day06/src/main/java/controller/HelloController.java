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
	 * 异常处理方法
	 * 当处理器的方法发生了异常就会调用异常处理方法来处理
	 * 注：e
	 * 处理器方法所抛出的异常
	 * @return
	 */
	public String handle(Exception e,HttpServletRequest req){
		//依据异常的类型，做不同的处理
		if(e instanceof NumberFormatException){
			req.setAttribute("msg", "填数字啊");
			return "error3";
		}else if(e instanceof StringIndexOutOfBoundsException){
			req.setAttribute("msg", "越界啊");
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
