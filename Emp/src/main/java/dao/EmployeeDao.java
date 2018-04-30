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
	//ɾ��Ա��
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
	
	
	//��ѯԱ��
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
			throw new RuntimeException("��ѯʧ��",e);
		}finally{
			DBUtil.close(conn);
			
			
		}
		return list;
	}
	
	//���Ա��
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
	 * ���쳣�ܷ�ָ���������ܹ��ָ�
	 * ���������ݿ��г�������ͣ�������жϵȣ���Щ�쳣һ���Ϊϵͳ�쳣����
	 * ����ʾ�û��Ժ����ԡ����쳣�׸�������
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

