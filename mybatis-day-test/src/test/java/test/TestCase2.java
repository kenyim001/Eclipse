package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.DeptDAO;
import entity.Dept;
import entity.Dt;

public class TestCase2 {
	private SqlSession session;
	private DeptDAO dao;
	@Before
	public void init(){
		String config="SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf=ssfb.build(TestCase2.class.getClassLoader().getResourceAsStream(config));
		session=ssf.openSession();
		dao=session.getMapper(DeptDAO.class);
	}
	
	@Test
	public void test1(){
		 Dept d=new Dept();
		 d.setDeptName("销售部");
		 d.setLoc("东莞");
		dao.save(d);
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		List<Dept> d=dao.findAll();
		System.out.println(d);
		session.close();
	}
	
	@Test
	public void test3(){
		Dept d=dao.findById(1);
		System.out.println(d);
		session.close();
	}
	
	@Test
	public void test5(){
		Dept d=dao.findById(1);
		d.setDeptName("经理");
		d.setLoc("昆明");
		dao.modify(d);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		dao.delete(1);
	}
	
	@Test
	public void test7(){
		Map d=dao.findById2(2);
		System.out.println(d);
		System.out.println(d.get("LOC"));
		session.close();
	}
		
	@Test
	public void test8(){
		Dt dt=dao.findById3(2);
		System.out.println(dt);
		session.close();

		
	}
}
