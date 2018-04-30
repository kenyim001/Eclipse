package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 处理类
 * 1.不用实现controller接口
 * 2.方法名不做要求，返回值是ModelAndView
 * 也可以是String
 * 3.可以用添加多个方法
 * 4.使用@Controller
 * 5.可以在方法前或者类前添加
 * @requestMapping(相当天heandlerMapping)
 * 
 * */
@Controller
//@RequestMapping("/demo")
public class HelloController {
	@RequestMapping("/hello.do")
		public String hello(){
			System.out.println("hello()");
			//返回视图名
			return "hello";
		}
}
