package test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.EmployeeDao;
import entity.Employee;
import util.DBUtil;


	public class TestCase {
		@Test
		//≤‚ ‘“« DButilπ§æﬂ¿‡
			public void test1(){
				Connection conn;
				try {
					conn = DBUtil.getConnection();
					System.out.println(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		@Test
		public void test2(){
			EmployeeDao dao=new EmployeeDao();
			Employee emp=new Employee();
			emp.setName("Giving King");
			emp.setSalary(12000);
			emp.setAge(22);
			dao.save(emp);
		}
	
	@Test
	public void test(){
		EmployeeDao dao=new EmployeeDao();
		List<Employee> list=new ArrayList();
		list=dao.findall();
		System.out.println(list);
	}
	}
	
