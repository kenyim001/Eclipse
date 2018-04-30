package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import entity.Employee;

public class TestCase {
	@Test
		public void test1(){
			String config="SqlMapConfig.xml";
			//����SqlSessionFactoryBuidler����
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			//����SqlSessionFactory����
			SqlSessionFactory ssf=ssfb.build(TestCase.class.getClassLoader().getResourceAsStream(config));
			//���SqlSession����
			SqlSession session=ssf.openSession();
			//����SqlSession�����ṩ �ķ�����������
			Employee e=new Employee();
			e.setName("Eric");
			e.setAge(33);
			session.insert("test.save",e);
			//��ӣ��޸ģ�ɾ������Ҫ�ύ����
			session.commit();
			//�ر�sqlsession
			session.close();
		}
	
	@Test
	public void test2(){
		for (int i = 1; i < 32; i++) {
			System.out.println("<option>"+i+"��</option>");
		}
		
	}
	
}
