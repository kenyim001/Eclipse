package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import emtity.Employee;

@Repository("empDAO")
public class EmployeeDAO {
		@Autowired
		@Qualifier("jt")
		private JdbcTemplate jt;
		/**
		 *JdbcTemplate会将底层的异常统一转换成运行时异常（runtimeException）然后抛出 
		 * 
		 * @param e
		 */
		
		public void save(Employee e){
			String sql="insert into t_emp_ghw values(t_emp_ghw_id.nextval,?,?,?)";
			Object[] args={e.getName(),e.getSalary(),e.getAge()};
			jt.update(sql,args);
		}
		
		public List<Employee> findAll(){
			String sql="select * from t_emp_ghw";
			return jt.query(sql,new EmpRowMapper());
		}
		
		public Employee findById(int id){
			String sql="select * from t_emp_ghw where id=?";
			Object[] args={id};
			
			Employee e=null;
			try {
				e=jt.queryForObject(sql, args,new EmpRowMapper());
			} catch (EmptyResultDataAccessException e1) {
				return null;
			}
			return e;
		}
		
		public void update(Employee e){
			String sql="update t_emp_ghw set name=?,salary=?,age=? where id=?";
			Object[] args={e.getName(),e.getSalary(),e.getAge(),e.getId()};
			jt.update(sql,args);
		}
		
		public void delect(int id){
			String sql="delete from t_emp_ghw where id=?";
			Object[] args={id};
			jt.update(sql,args);
			
		}
		
		//告诉JdbcTemplate如何处理Resultset
		class EmpRowMapper implements RowMapper<Employee>{
				/**
				 * index:正在被处理的记录的下标在该方法里面，告诉JdbcTemplate
				 * 如何将记录转换成一个实体对象
				 */
			public Employee mapRow(ResultSet rs, int index) throws SQLException {
				Employee e=new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				return e;
			}
		}
		
		
		
}
