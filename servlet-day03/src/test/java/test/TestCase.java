package test;
import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import dao.EmployeeDAO;
import entity.Employee;
import util.DBUtil;
public class TestCase {
	
	@Test
	//测试 DBUtil工具类
	public void test1() throws Exception{
		Connection conn=DBUtil.getConnection();
		System.out.println(conn);
		conn.close();
	}
	
	@Test
	//测试EmployeeDAO save方法
	public void test2(){
		EmployeeDAO dao=new EmployeeDAO();
		Employee emp=new Employee();
		emp.setName("Giving King");
		emp.setSalary(12000.0);
		emp.setAge(28);
		dao.save(emp);
	}
	
	@Test
	//测试EmployeeDAO findAll方法
	public void test3(){
		EmployeeDAO dao=new EmployeeDAO();
		List<Employee> list=dao.findAll();
		for(Employee emp:list){
			System.out.println(emp);
		}
	}
	
	@Test
	//测试EmployeeDAO delete方法
	public void test4(){
		EmployeeDAO dao=new EmployeeDAO();
		dao.delete(134);
	}
	
	@Test
	//测试EmployeeDAO findById方法
	public void test5(){
		EmployeeDAO dao=new EmployeeDAO();
		Employee emp=dao.findById(138);
		System.out.println(emp);
	}
	
	@Test
	//测试EmployeeDAO modify方法
	public void test6(){
		EmployeeDAO dao=new EmployeeDAO();
		Employee emp=dao.findById(141);
		emp.setSalary(emp.getSalary()*2);
		dao.modify(emp);
	}

}
