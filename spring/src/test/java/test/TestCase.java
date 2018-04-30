package test;


import javax.swing.AbstractAction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import basic.MessageService;
import basic.Teacher;


public class TestCase {
	@Test
	//测试作用域和延迟方法
	public void test1(){
		String config="basic.xml";
		//启动spring容器
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		//通过容器获得bean
//		Teacher t1=ac.getBean("t1",Teacher.class);
//		Teacher t2=ac.getBean("t1",Teacher.class);
//		System.out.println(t1);
//		System.out.println(t2);
//		System.out.println(t1==t2);
	}
	
	@Test
	//测试生命周期相关的两个方法
	public void test2(){
		String config="basic.xml";
		//启动spring容器
		/*
		 * ApplicationContext没有的提供关闭容器的方法（close方法）
		 * 需要用其子接口AbstractApplicationContext
		 * */
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("basic.xml");
		MessageService ms1=ac.getBean("ms1",MessageService.class);
		//关闭容器
		ac.close();
	}
	
}
