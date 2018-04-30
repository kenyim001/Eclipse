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
			//记日志
			e.printStackTrace();
			/**
			 * 如果是系统异常，应该提示用户稍后再试（这里直接将系统异常抛出即可）
			 * 注：表示层可以统一处理系统异常给用户相应提示，比如稍后重试
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
	

