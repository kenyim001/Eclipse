package first;


import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
		/**
		 * 
		 * ApplicationContext是一个接口
		 * ClassPathXmlApplicationContext是一个具体类实现了上述接口
		 * 注：该类依据路径来查找配置文件，并且启动容器
		 */
				
		public static void main(String[] args) {
			String config="spring-mvc.xml";
			ApplicationContext ac=
					new ClassPathXmlApplicationContext(config);
//			System.out.println(ac);
			
//			通过容器，获得一个对象
			/**
			 * Apple.class 方法区中的Apple类对应的class对象
			 */
			
				Apple apple=ac.getBean("apple",Apple.class);
				System.out.println(apple);
				
				Date date=ac.getBean("date",Date.class);
				System.out.println(date);
				
				Calendar cal1=ac.getBean("cal1",Calendar.class);
				System.out.println(cal1);
				
				Date time1=ac.getBean("time1",Date.class);
				System.out.println("time1："+time1);
		}
}
