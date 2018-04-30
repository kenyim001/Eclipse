package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * ������
 * 1.����ʵ��controller�ӿ�
 * 2.����������Ҫ�󣬷���ֵ��ModelAndView
 * Ҳ������String
 * 3.��������Ӷ������
 * 4.ʹ��@Controller
 * 5.�����ڷ���ǰ������ǰ���
 * @requestMapping(�൱��heandlerMapping)
 * 
 * */
@Controller
//@RequestMapping("/demo")
public class HelloController {
	@RequestMapping("/hello.do")
		public String hello(){
			System.out.println("hello()");
			//������ͼ��
			return "hello";
		}
}
