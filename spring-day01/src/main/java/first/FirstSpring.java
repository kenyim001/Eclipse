package first;


import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
		/**
		 * 
		 * ApplicationContext��һ���ӿ�
		 * ClassPathXmlApplicationContext��һ��������ʵ���������ӿ�
		 * ע����������·�������������ļ���������������
		 */
				
		public static void main(String[] args) {
			String config="spring-mvc.xml";
			ApplicationContext ac=
					new ClassPathXmlApplicationContext(config);
//			System.out.println(ac);
			
//			ͨ�����������һ������
			/**
			 * Apple.class �������е�Apple���Ӧ��class����
			 */
			
				Apple apple=ac.getBean("apple",Apple.class);
				System.out.println(apple);
				
				Date date=ac.getBean("date",Date.class);
				System.out.println(date);
				
				Calendar cal1=ac.getBean("cal1",Calendar.class);
				System.out.println(cal1);
				
				Date time1=ac.getBean("time1",Date.class);
				System.out.println("time1��"+time1);
		}
}
