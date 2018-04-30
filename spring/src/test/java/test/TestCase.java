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
	//������������ӳٷ���
	public void test1(){
		String config="basic.xml";
		//����spring����
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		//ͨ���������bean
//		Teacher t1=ac.getBean("t1",Teacher.class);
//		Teacher t2=ac.getBean("t1",Teacher.class);
//		System.out.println(t1);
//		System.out.println(t2);
//		System.out.println(t1==t2);
	}
	
	@Test
	//��������������ص���������
	public void test2(){
		String config="basic.xml";
		//����spring����
		/*
		 * ApplicationContextû�е��ṩ�ر������ķ�����close������
		 * ��Ҫ�����ӽӿ�AbstractApplicationContext
		 * */
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("basic.xml");
		MessageService ms1=ac.getBean("ms1",MessageService.class);
		//�ر�����
		ac.close();
	}
	
}
