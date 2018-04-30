package Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;

public class TestCase {
	@Test
	public void test1(){
		String config="mybatis-spring.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		EmployeeDAO dao=ac.getBean("employeeDAO",EmployeeDAO.class);
		
		System.out.println(dao.findAll());
	}
}
