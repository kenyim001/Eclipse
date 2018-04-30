package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import util.DBUtil;

public class UserDao {
		public User findByUsername(String username){
			Connection conn=null;
			User user=null;
			
			try {
				conn=DBUtil.getConnection();
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
			
			return user;
		}
}
