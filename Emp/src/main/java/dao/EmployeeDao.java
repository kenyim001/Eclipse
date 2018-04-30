package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import entity.Employee;
import util.DBUtil;

public class EmployeeDao {
	//删掉员工
	public void del(int id){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from t_emp where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	
	//查询员工
	public List<Employee> findall(){
		List<Employee> list=new ArrayList();
		Connection conn=null;
		try {
			conn = DBUtil.getConnection();
			String sql="select * from t_emp";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Employee emp=new Employee();
				emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			emp.setSalary(rs.getDouble("salary"));
			list.add(emp);
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		}finally{
			DBUtil.close(conn);
			
			
		}
		return list;
	}
	
	//添加员工
	public void save(Employee emp) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql="INSERT INTO t_emp VALUES(t_emp_seq.nextval,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,emp.getName());
			ps.setDouble(2,emp.getSalary());
			ps.setInt(3,emp.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
	/*
	 * 看异常能否恢复，如果不能够恢复
	 * （比如数据库有出服务暂停，网络中断等，这些异常一般称为系统异常）。
	 * 则提示用户稍后重试。将异常抛给调用者
	 * 
	 * */		
			throw new RuntimeException(e);
		}finally{
			if(conn != null){
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

