package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Emp;
import entity.Employee;


public class TestCase {
	private SqlSession session;
	@Before
	public void init(){
		String config="SqlMapConfig.xml";
		//创建SqlSessionFactoryBuidler对象
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//创建SqlSessionFactory对象
		SqlSessionFactory ssf=ssfb.build(TestCase.class.getClassLoader().getResourceAsStream(config));
		//获得SqlSession对象
		 session=ssf.openSession();
	}
	
	@Test
		public void test1(){
			
			//调用SqlSession对象提供 的方法访问数据
			Employee e=new Employee();
			e.setName("Eric");
			e.setSalary(5000.0);
			e.setAge(33);
			session.insert("text.save",e);
			//添加，修改，删除都需要提交事务
			session.commit();
			//关闭sqlsession
			session.close();
		}
	
	@Test
	public void test2(){
		List<Employee> employees=session.selectList("test.findAll");
 		System.out.println(employees);
		//关闭sqlsession
		session.close();
	}
	
	@Test
	public void test(){
		Employee e=session.selectOne("test.findById",101);
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test3(){
		Employee e=session.selectOne("test.findById",101);
		System.out.println(e);
		e.setName("李奶奶");
		e.setSalary(50000.0);
		e.setAge(360);
		
		session.update("test.modify",e);
		e=session.selectOne("test.findById",101);
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		session.delete("test.delete",101);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		Map data=session.selectOne("test.findById2",100);
		System.out.println(data.get("NAME"));
		System.out.println(data.get("AGE"));
		session.close();
	}
	
	@Test
	//测试 解决表的字段名与实体类的属性名不一性的情况
	public void test7(){
		Emp emp=session.selectOne("test.findById3",100);
		System.out.println(emp);
		session.close();
	}
}
