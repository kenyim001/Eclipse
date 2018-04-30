package springjdbc;

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
	
		/*@before���εķ��������������Է�������֮ǰ��ִ��
		 * */
	
		public void init(){
			String config="spring-jdbc.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			 dao=ac.getBean("employeeDAO",EmployeeDAO.class);
		}
		
		@Test
		public void test1(){
			String config="spring-jdbc.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			EmployeeDAO dao=ac.getBean("employeeDAO",EmployeeDAO.class);
			Employee e=new Employee();
			e.setName("GivingKing");
			e.setAge(22);
			dao.save(e);
		}
		
		@Test
		public void test2(){
			List<Employee> employees=dao.findAll();
			System.out.println(employees);
		}
		
		@Test
		public void test3(){
			Employee e=dao.findByID(3);
			System.out.println(e);
		}
		@Test
		public void test4(){
			Employee e=dao.findByID(2);
			e.setAge(e.getAge()+10);
			dao.modify(e);
			System.out.println(e);
		}
		@Test
		public void test5(){
			dao.delete(2);
		}
}
