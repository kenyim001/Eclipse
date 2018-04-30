package Test;


import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.User;



public class TestCase {
	private Configuration cfg;
	private SessionFactory factory;
	private Session session;
	private Transaction tx;
	@Before
	public void init(){
		 cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		 factory=cfg.buildSessionFactory();
		 session=factory.openSession();
		 tx =session.beginTransaction();
	}
	@After
	public void close(){
		 session.close();
		 factory.close();
	}
	
	@Test
	public void testSaveUser(){
		//创建Session对象
		long now=System.currentTimeMillis();
		User user=new User(1,"Tom","123",4,4.5,new Date(now));
		session.save(user);
		tx.commit();
	
	}
	
	
	@Test
	public void testGetById(){
		//初始化Hibernate获取session对象
		//调用get方法
		//get(类型，对象的主键id)
		 User user=(User)session.get(User.class,1);
		 System.out.println(user);
	}
	
	@Test
	public void testUpdate(){
		User user=(User)session.get(User.class, 1);
		System.out.println(user);
		user.setName("威哥");
		session.update(user);
		user=(User)session.get(User.class, 1);
		System.out.println(user);
		tx.commit();
	}
	
	@Test
	public void testDelete(){
		User user=(User)session.get(User.class, 1);
		session.delete(user);
		tx.commit();
	}
	
	@Test
	public void testFindAll(){
		//sql:select * from t_user
		//hql:from User
		String hql="from User";
		//利用Query接口可以执行HQl语句
		Query query=session.createQuery(hql);
		//list 方法执行HQl语句
		List<User> list=query.list();
		for(User user:list){
			System.out.println(user);
		}
	
	}
	
	@Test
	public void testByMap(){
		//sql:select u_id,u_name from t_user
		//hql:select new map(id as id,name as name )from User
		String hql="select new map(id as id,name as name )from User";
		Query query=session.createQuery(hql);
		List<Map<String,Object>> list=query.list();
		for(Map<String,Object> map:list){
			System.out.println(map);
		}
	}
	
	
	@Test
	public void testFindByParam(){
		//Sql:select u_id,u_name,u_password form t_user where u_name=?
		//hql:select new map(id as id,name as name,password as password) form user where name=?
	String name="Tom";
	String hql="select new map(id as id,name as name,password as password) from User where name=?";
	Query query=session.createQuery(hql);
	//替换查询参数
	query.setString(0, name);
	List<Map<String,Object>> list=query.list();
	for(Map<String,Object> map:list){
		System.out.println(map);
	}
	}
	
}
