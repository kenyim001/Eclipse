package cn.tedu.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;
@Repository("userDAO")
public class UserDAOSpringJdbcImpl implements UserDAO {
	@Resource(name="jt")
	private JdbcTemplate jt;
	public User findByUsername(String username) {
		String sql = "SELECT * FROM t_user WHERE username=?";
		Object[] args={username};
		User user=null;
		try {
			user=jt.queryForObject(sql,args,new UserRowMapper());
		} catch (EmptyResultDataAccessException e1) {
			return null;
		}
		return user;
	}
	
	class UserRowMapper implements RowMapper<User>{
		/**
		 * index:正在被处理的记录的下标在该方法里面，告诉JdbcTemplate
		 * 如何将记录转换成一个实体对象
		 */
	public User mapRow(ResultSet rs, int index) throws SQLException {
		User e=new User();
		e.setName(rs.getString("username"));
		e.setPwd(rs.getString("password"));
		return e;
	}
 }
}