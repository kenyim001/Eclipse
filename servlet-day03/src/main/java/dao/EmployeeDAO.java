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
	
	/**
	 * 修改员工信息
	 * @param emp
	 */
	public void modify(Employee emp){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE t_emp_ghw SET name=?,age=?,salary=? WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			int id=emp.getId();
			String name=emp.getName();
			int age=emp.getAge();
			double salary=emp.getSalary();
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setDouble(3, salary);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 依据id查询员工信息
	 * @param id
	 * @return
	 */
	public Employee findById(int id){
		Employee emp=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT * FROM t_emp_ghw WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				emp=new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getDouble("salary"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return emp;
	}
	
	
	
	
	/**
	 * 根据id删除某个员工信息
	 * @param id
	 */
	public void delete(int id){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="DELETE FROM t_emp_ghw WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	
	/**
	 * 判断是否有给定id
	 * @param id
	 * @return
	 */
	public boolean isHasId(int id){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT id,name,age,salary FROM t_emp_ghw WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
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
	
	
	/**
	 * 将员工表中所有员工信息查询出来
	 */
	public List<Employee> findAll(){
		List<Employee> list=new ArrayList<Employee>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT id,name,salary,age FROM t_emp_ghw";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				double salary=rs.getDouble("salary");
				int age=rs.getInt("age");
				Employee emp=new Employee(id, name, salary, age);
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
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
	
	
	/**
	 * 添加员工
	 */
	public void save(Employee emp){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			
			String sql="INSERT INTO t_emp_ghw VALUES (t_emp_ghw_id.NEXTVAL,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setInt(3, emp.getAge());
			ps.executeUpdate();
		} catch (Exception e) {
			//记日志(保留现场)
			e.printStackTrace();
			/*
			 * 看异常能否恢复，如果不能够恢复（比如数据库服务暂停，网络中断等，这些异常一般称之为系统异常）,
			 * 则提示用户稍后重试
			 */
			//将异常抛给调用者
			throw new RuntimeException(e);
		} finally{
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
