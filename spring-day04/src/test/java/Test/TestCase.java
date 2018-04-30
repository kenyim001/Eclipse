package Test;



import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ems.controller.User;
import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.servicce.LoginService;



public class TestCase {
	
	@Test
	//≤‚ ‘¡¨Ω”≥ÿ
	public void test1() throws SQLException{
		String config="spring-mvc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		DataSource ds=ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
	
	@Test
	//≤‚ ‘ ≥÷æ√≤„
	public void test2(){
		String config="spring-mvc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		UserDAO dao=ac.getBean("userDAO",UserDAO.class);
		User user=dao.FindByUsername("Sally");
		System.out.println(user);
	}
	
	@Test
	public void test3(){
		String config="spring-mvc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		LoginService ls=ac.getBean("loginSerivce",LoginService.class);
		User user=ls.checkLogin("Sally1","1234");
		System.out.println(user);
	}
}
