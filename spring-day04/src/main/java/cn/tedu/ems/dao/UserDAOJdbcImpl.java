package cn.tedu.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.ems.controller.User;

@Repository("userDAO")
public class UserDAOJdbcImpl implements UserDAO{
	@Resource(name="ds")
	private DataSource ds;
	public User FindByUsername(String username){
		User user=null;
		Connection conn=null;
		
		try {
			conn=ds.getConnection();
			String sql="SELECT * FROM t_user WHERE username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("password"));
				user.setGendar(rs.getString("gendar"));
				
			}
		} catch (SQLException e) {
			//����־
			e.printStackTrace();
			/**
			 * �����ϵͳ�쳣��Ӧ����ʾ�û��Ժ����ԣ�����ֱ�ӽ�ϵͳ�쳣�׳����ɣ�
			 * ע����ʾ�����ͳһ����ϵͳ�쳣���û���Ӧ��ʾ�������Ժ�����
			 */
			throw new RuntimeException(e);
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
				}
			
			}
		}
		
		return user;
	}
}
	

