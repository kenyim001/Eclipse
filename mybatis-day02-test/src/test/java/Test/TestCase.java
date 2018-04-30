package Test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DeptDAO;
import entity.Dept;

public class TestCase {
	@Test
	public void test1(){
		String config="mybatis-spring.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		DeptDAO d=ac.getBean("deptDAO",DeptDAO.class);
		List<Dept> dept=d.findAll();
		System.out.println(dept);
				
	}
}
