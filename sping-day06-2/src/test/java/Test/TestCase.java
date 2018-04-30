package Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import dao.EmployeeDAO;
import emtity.Employee;

public class TestCase {
	private ApplicationContext ac;
	private EmployeeDAO dao;
	@Before
	//会在所有的test运行前先执行
	public void init(){
		String config="springjdbc.xml";
		 ac=new ClassPathXmlApplicationContext(config);
		 dao=ac.getBean("empDAO",EmployeeDAO.class);
	}
	
		@Test
		//测试 连接池
		public void test1() throws SQLException{
			String config="springjdbc.xml";
			ApplicationContext ac=new ClassPathXmlApplicationContext(config);
			DataSource ds=ac.getBean("ds",DataSource.class);
			System.out.println(ds.getConnection());
		}
		
		@Test
		//测试 save方法
			public void test2(){
			Employee e=new Employee();
			e.setName("你老鼠");
			e.setSalary(2000.0);
			e.setAge(28);
			dao.save(e);
		}
		
		@Test
		//测试findAll
		public void test3(){
			List<Employee> emps=dao.findAll();
			System.out.println(emps);
		}
		
		@Test
		//测试 findById
		public void test4(){
			Employee e=dao.findById(22);
			System.out.println(e);
		}
		
		@Test
		//测试修改方法
		public void test5(){
			Employee e=dao.findById(220);
			e.setAge(e.getAge()*2);
			e.setSalary(e.getSalary()/2);
			dao.update(e);
			System.out.println(e);
		}
		
		@Test
		public void test6(){
			dao.delect(221);
		}
		
		}

