package spring2;


import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Test.Restaurant;
import Test1.Car;
import autowire.Bar;
import ioc.A;
import ioc.Manager;
import value.ExampleBean;
import value.InfoBean;
import value.ValueBean;

public class TestCase {
	@Test
	//测试Set方法注入
	public void test1(){
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		A a=ac.getBean("a1",A.class);
		a.execute();
	}
	
	@Test
	public void test2(){
		String config="test.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Restaurant restaurant=ac.getBean("a1",Restaurant.class);
		restaurant.execute();
	}
	
	@Test
	//测试构造器注入
	public void test3(){
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Manager mg1=ac.getBean("mg1",Manager.class);
		System.out.println(mg1);
	}
	
	@Test
	//测试 自动装配
	public void test4(){
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Bar bar=ac.getBean("bar",Bar.class);
		System.out.println(bar);
	}
	
	@Test
	public void test5(){
		String config="test1.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Car car=ac.getBean("Car",Car.class);
		System.out.println(car);
	}
	
	@Test
	public void test6(){
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ValueBean vb=ac.getBean("vb1",ValueBean.class);
		System.out.println(vb);
	}
	
	@Test
	//测试集合类型的值的注入
	public void test7(){
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ExampleBean eb=ac.getBean("ee1",ExampleBean.class);
		System.out.println(eb);
	}
	
	//测试集合类型的值的注入
	@Test
		public void test8(){
			String config="value.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			Properties props=ac.getBean("config",Properties.class);
			System.out.println(props);
		}
	@Test
	public void test9(){
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		InfoBean ib1=ac.getBean("ib1",InfoBean.class);
		System.out.println(ib1);
				
	}
	}


