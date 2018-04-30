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
		//����SqlSessionFactoryBuidler����
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//����SqlSessionFactory����
		SqlSessionFactory ssf=ssfb.build(TestCase.class.getClassLoader().getResourceAsStream(config));
		//���SqlSession����
		 session=ssf.openSession();
	}
	
	@Test
		public void test1(){
			
			//����SqlSession�����ṩ �ķ�����������
			Employee e=new Employee();
			e.setName("Eric");
			e.setSalary(5000.0);
			e.setAge(33);
			session.insert("text.save",e);
			//��ӣ��޸ģ�ɾ������Ҫ�ύ����
			session.commit();
			//�ر�sqlsession
			session.close();
		}
	
	@Test
	public void test2(){
		List<Employee> employees=session.selectList("test.findAll");
 		System.out.println(employees);
		//�ر�sqlsession
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
		e.setName("������");
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
	//���� �������ֶ�����ʵ�������������һ�Ե����
	public void test7(){
		Emp emp=session.selectOne("test.findById3",100);
		System.out.println(emp);
		session.close();
	}
}
