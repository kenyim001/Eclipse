package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.Bar;
import ioc.Leader;
import ioc.Restaurant;
import ioc.Student;
import ioc.UserBean;

public class TestCase {
	
		@Test
		//测试 组件扫描
		public void test1(){
			String cofiig="ioc.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(cofiig);
			Student stu=ac.getBean("student",Student.class);
			System.out.println(stu);
			Student stu1=ac.getBean("student",Student.class);
			System.out.println(stu1);
			System.out.println(stu1==stu);
		
		}
		@Test
		//测试 周期
		public void test2(){
			String cofiig="ioc.xml";
			AbstractApplicationContext ac=new ClassPathXmlApplicationContext(cofiig);
			Student stu=ac.getBean("student",Student.class);
			ac.close();			
		}
		
		@Test
		//测试 周期
		public void test3(){
			String cofiig="ioc.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(cofiig);
			Restaurant rest=ac.getBean("rest",Restaurant.class);
			System.out.println(rest);
		}
		@Test
		//测试 周期
		public void test4(){
			String cofiig="ioc.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(cofiig);
			Restaurant rest=ac.getBean("rest",Restaurant.class);
			System.out.println(rest);
			Bar bar=ac.getBean("bar",Bar.class);
			System.out.println(bar);
		}
		
		@Test
		public void test5(){
			String cofiig="ioc.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(cofiig);
			Leader ld=ac.getBean("leader",Leader.class);
			System.out.println(ld);
		}
		
		@Test
		//测试 @Value
		public void test(){
			String config="ioc.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			UserBean ub=ac.getBean("user",UserBean.class);
			System.out.println(ub);
			
		}
		
}