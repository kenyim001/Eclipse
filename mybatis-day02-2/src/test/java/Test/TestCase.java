package Test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {
	private EmployeeDAO dao;
	@Before
	public void init(){
	String config="mybatis-spring.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	dao=ac.getBean("empDAO",EmployeeDAO.class);
	}
	
	@Test
	public void test1(){
		Employee e=new Employee();
		e.setName("爱你");
		e.setAge(18);
		e.setSalary(1000);
		dao.save(e);
		
	}
	
	@Test
	public void test2(){
		List<Employee> emps=dao.findAll();
		System.out.println(emps);
				
	}
}