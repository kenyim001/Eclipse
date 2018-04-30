package cn.tedu.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;
/**
 * 鎸佷箙灞傚疄鐜扮被
 */

//@Repository("userDAO")
public class UserDAOJdbcImpl implements 
UserDAO{
	
	@Resource(name="ds")
	private DataSource ds;
	
	public User findByUsername(
			String username) {
		User user = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM "
					+ "t_user WHERE username=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = 
					ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(
						rs.getString("username"));
				user.setPwd(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGendar(rs.getString("gendar"));
			}
		} catch (SQLException e) {
			//璁版棩蹇�
			e.printStackTrace();
			/*
			 * 濡傛灉鏄郴缁熷紓甯革紝搴旇鎻愮ず鐢ㄦ埛
			 * 绋嶅悗閲嶈瘯锛堣繖鍎跨洿鎺ュ皢绯荤粺寮傚父
			 * 鎶涘嚭鍗冲彲锛�
			 * 娉細
			 * 	琛ㄧず灞傚彲浠ョ粺涓�澶勭悊绯荤粺寮傚父锛�
			 * 缁欑敤鎴风浉搴旀彁绀猴紝姣斿绋嶅悗閲嶈瘯銆�
			 */
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
		return user;
	}

}

