package Test;

import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotations.Apple;
import ioc.Manager;
import value.ExampleBean;
import value.SomeBean;

public class TestCase {
  @Test
	public void test1(){
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Manager mg=ac.getBean("mg",Manager.class);
		System.out.println(mg);
	}
	
  @Test
  //测试 注入基本类型的值
  public void test2(){
  String config="value.xml";
  ApplicationContext ac=new ClassPathXmlApplicationContext(config);
  ExampleBean eb1=ac.getBean("eb1",ExampleBean.class);
  System.out.println(eb1);
  System.out.println(eb1.getName());
  System.out.println(eb1.getScore().get("english"));
 
	}
  
  @Test
  //测试 注入基本类型的值
  public void test3(){
  String config="value.xml";
  ApplicationContext ac=new ClassPathXmlApplicationContext(config);
  ExampleBean eb1=ac.getBean("eb2",ExampleBean.class);
  System.out.println(eb1);
	}
  
  @Test
  //测试 读取.properties文件
  public void test4(){
	  String config="value.xml";
	  ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	  Properties props=ac.getBean("config",Properties.class);
	  System.out.println(props);
  }
  
  @Test
  //测试 Spring表达式
  public void test5(){
	  String config="value.xml";
	  ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	  SomeBean sb1=ac.getBean("sb1",SomeBean.class);
	  System.out.println(sb1);
  }
  
  @Test
  public void test6(){
	  String config="DBUtil.xml";
	  ApplicationContext ac=new ClassPathXmlApplicationContext(config);
	  /**
	   * javax.sql.dataSource是一个接口
	   * BasicDataSource实现了该接口
	   */
	  
//	  BasicDataSource ds=ac.getBean("ds",BasicDataSource.class);
	  //用父类做接口
	  DataSource d=ac.getBean("d",DataSource.class);
	  System.out.println(d);
	  try {
		System.out.println(d.getConnection());
		
		System.out.println("连接成功");
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }	  
	 @Test
	 //测试 组件扫描
	 public void test7(){
		  String config="DBUtil.xml";
		  AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		  Apple apple=ac.getBean("ap1",Apple.class);
		  ac.close();

  }
  
}