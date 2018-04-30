package test;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmployeeDAO;
import entity.Emp;
import entity.Employee;

public class TestCase2 {
	private SqlSession session;
	@Before
	public void init(){
		String config="SqlMapConfig.xml";
		//创建SqlSessionFactoryBuidler对象
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//创建SqlSessionFactory对象
		SqlSessionFactory ssf=ssfb.build(TestCase2.class.getClassLoader().getResourceAsStream(config));
		//获得SqlSession对象
		 session=ssf.openSession();
	}
	@Test
	public void test1(){
	//获得映射器视的实现
	/**
	 * MyBatis在底层会依据接口要求（即Mapper映射器）生成符合接口的对象	
	 */
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		Employee e=new Employee();
		e.setName("Kitty");
		e.setSalary(2000);
		e.setAge(22);
		dao.save(e);
		//仍然需要提交事务
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		List<Employee> e=dao.findAll();
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test3(){
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		Employee e=dao.findById(100);
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test4(){
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		Employee e=dao.findById(100);
		e.setName("李奶奶");
		e.setSalary(3000.0);
		e.setAge(33);
		dao.modify(e);
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		dao.delete(103);
		session.commit();
		session.close();
	}

	@Test
	public void test6(){
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		Map e=dao.findById2(100);
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test7(){
		EmployeeDAO dao=session.getMapper(EmployeeDAO.class);
		Emp emp=dao.findById3(100);
		System.out.println(emp);
		session.close();
	}
}
