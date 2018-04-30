package Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.ExampleBean;
import basic.LazyBean;
import basic.MessageBean;
import basic.ScopeBean;
import ioc.Bar;
import ioc.Restaurant;
import ioc.a;

public class TestCase {
	@Test
	public void test1(){
		String config="basic.xml";
		/**
		 * 	��ΪApplicatiocontext�ӿ�û���ṩclose������������Ҫʹ�����ӽӿ�
		 * Abstractapplictioncontext
		 * 
		 */
		
		AbstractApplicationContext ac=new  ClassPathXmlApplicationContext(config);
		ExampleBean eb1=ac.getBean("eb1",ExampleBean.class);
		eb1.service();
		//�ر�����
		ac.close();
	}

	@Test

	public void test2(){
		String config="basic.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ScopeBean sb1=ac.getBean("sb1",ScopeBean.class);
		ScopeBean sb2=ac.getBean("sb1",ScopeBean.class);
		System.out.println(sb1==sb2);
	}
	
	@Test
	//���� �ӳټ���
	public void test3(){
		String config="basic.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		LazyBean lb1=ac.getBean("lb1",LazyBean.class);
		System.out.println(lb1);
	} 
	
	@Test
	public void test4(){
		String config="basic.xml";
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		MessageBean mb1=ac.getBean("mb1",MessageBean.class);
		ac.close();		
	}
	
	@Test
	//���� set����ע��
	public void test5(){
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		a a1=ac.getBean("a1",a.class);
		a1.service();
	}
	
	@Test
	public void test6(){
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Restaurant rest1=ac.getBean("res1",Restaurant.class);
	}
	
	@Test
	//���Թ�����ע��
	public void test7(){
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Bar bar1=ac.getBean("bar1",Bar.class);
		System.out.println(bar1);
	}
	
		@Test
		public void test8(){
			String config="ioc.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			Restaurant restaurant1=ac.getBean("restaurant1",Restaurant.class);
			System.out.println(restaurant1);
	
	}
}