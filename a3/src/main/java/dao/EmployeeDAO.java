package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
import util.DBUtil;

public class EmployeeDAO {

	//增加员工
	public void save (Employee emp){
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="insert into t_emp_ghw values(t_emp_ghw_id.nextval,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setInt(3, emp.getAge());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(conn!=null){
				
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				
			}
		}
	}
	
	//找查所有员工
	public List<Employee> findAll(){
		List<Employee> list=new ArrayList<Employee>();
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="select id,name,salary,age from t_emp_ghw";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
			double salary=rs.getDouble("salary");
			int age=rs.getInt("age");
			Employee emp=new Employee(id,name,salary,age);
			list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if(conn!=null){
				
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		
		return list;
	}
	
	public void delete(int id){
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="Delete from t_emp_ghw where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			if(conn!=null){
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
	}

	

}
