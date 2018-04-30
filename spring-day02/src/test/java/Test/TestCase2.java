package Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotations.Apple;
import annotations.Car;
import annotations.Leader;
import annotations.Manager;
import annotations.Student;


public class TestCase2 {
		@Test
		//≤‚ ‘◊Èº˛…®√Ë
		public void l(){
			String config="annoutations.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			Apple apple=ac.getBean("ap1",Apple.class);
			System.out.println(apple);
		}
		 @Test
		 //≤‚ ‘ ◊Èº˛…®√Ë
		 public void test7(){
			  String config="annoutations.xml";
			  AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
			  Apple apple=ac.getBean("ap1",Apple.class);
			  ac.close();
	  }

		 @Test
		 //≤‚ ‘ —”≥Ÿº”‘ÿ
		 public void test3(){
			  String config="annoutations.xml";
			  AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
			  
		 }
		 
		 @Test
		 //≤‚ ‘@Autowired @Qualifier
		 public void test4(){
			  String config="annoutations.xml";
			  AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
			 Manager mg=ac.getBean("mg",Manager.class);
			 System.out.println(mg);
			 Leader ld= ac.getBean("ld",Leader.class);
			 System.out.println(ld);
		 }
		 
		 @Test
		 //≤‚ ‘@Resource
		 public void test5(){
			  String config="annoutations.xml";
			  AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
			  Student stu=ac.getBean("stu",Student.class);
			  System.out.println(stu);
			  }
		 
		 @Test
		 //≤‚ ‘@Resource
		 public void test6(){
			  String config="annoutations.xml";
			  AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
			  Car car=ac.getBean("car",Car.class);
			  System.out.println(car);
			  }
		 
}
