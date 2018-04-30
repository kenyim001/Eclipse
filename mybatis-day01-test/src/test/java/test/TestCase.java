package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Dept;

public class TestCase {
	private SqlSession session;
	@Before
	public void init(){
		String config="SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf=ssfb.build(Test.class.getClassLoader().getResourceAsStream(config));
		session=ssf.openSession();
	}
	
	@Test
	public void test(){
		Dept d=new Dept();
		d.setDeptName("经理111");
		d.setLoc("东莞111");
	
		session.insert("test.save",d);
		session.commit();
		session.close();
	}
	
	
	@Test
	public void test1(){
		List<Dept> dept=session.selectList("test.findAll");
		System.out.println(dept);
		session.close();
	}
	
	@Test
	public void test2(){
		Dept d=session.selectOne("test.findById",1);
		System.out.println(d);
		session.close();
	}
	
	@Test
	public void test3(){
		Dept d=session.selectOne("test.findById",1);
		System.out.println(d);
		d.setDeptName("员工");
		d.setLoc("上海");
		session.update("test.modify",d);
		session.commit();
		session.close();
	}
	
	@Test
	public void test4(){
		session.delete("test.delete",1);
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		Map data=session.selectOne("test.findById2",1);
		System.out.println(data);
		session.close();
	}
}
