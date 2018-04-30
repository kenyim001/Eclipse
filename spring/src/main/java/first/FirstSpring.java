package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
		
		public static void main(String[] args) {
			String config="applicationContext.xml";
			/*
			 * ApplicationContext是接口
			 * ClassPathXmlApplicationContext是一个实现类，该类会依据类路径去
			 * 查找SPring配置文件，然后启动容器
			 *  
			 *  */
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
//			System.out.println(ac);
//			Student.class 方法区中的class对象
			Student stu=ac.getBean("stu1",Student.class);
//			java反射
//			类加载器 方法驱
			System.out.println(stu);
			
			Date a=ac.getBean("date1",Date.class);
			System.out.println(a);
			
			Calendar cal1=ac.getBean("cal1",Calendar.class);
			System.out.println("a"+cal1);
			
			Date time=ac.getBean("time1",Date.class);
			System.out.println("b"+time);
		}
}
