package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
		
		public static void main(String[] args) {
			String config="applicationContext.xml";
			/*
			 * ApplicationContext�ǽӿ�
			 * ClassPathXmlApplicationContext��һ��ʵ���࣬�����������·��ȥ
			 * ����SPring�����ļ���Ȼ����������
			 *  
			 *  */
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
//			System.out.println(ac);
//			Student.class �������е�class����
			Student stu=ac.getBean("stu1",Student.class);
//			java����
//			������� ������
			System.out.println(stu);
			
			Date a=ac.getBean("date1",Date.class);
			System.out.println(a);
			
			Calendar cal1=ac.getBean("cal1",Calendar.class);
			System.out.println("a"+cal1);
			
			Date time=ac.getBean("time1",Date.class);
			System.out.println("b"+time);
		}
}
