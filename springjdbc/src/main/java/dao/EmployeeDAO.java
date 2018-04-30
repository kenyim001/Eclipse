package dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Employee;
@Repository("employeeDAO")
public class EmployeeDAO {		
	@Resource(name="jt")
			private JdbcTemplate jt;
			
			public void save(Employee e){
					String sql="insert into t_emp VALUES(t_emp_seq.nextval,?,?)";
					System.out.println("1111");
					Object[] args={e.getName(),e.getAge()};
					jt.update(sql,args);
					System.out.println("2222");
			}
			public List<Employee> findAll(){
				String sql="select * from t_emp";
				
			return jt.query(sql,new EmpRowMapper());
				
			}
			class EmpRowMapper implements RowMapper<Employee>{
				/*告诉JdbcTemplate,如何将一条记录转换成一个实体对象
				 * Index:正在被处理的记录的下标
				 * */
				public Employee mapRow(
						ResultSet rs,int index)throws SQLException{
					Employee e=new Employee();
					e.setId(rs.getInt("id"));
					e.setName(rs.getString("name"));
					e.setAge(rs.getInt("age"));
					return e;
				}
			}
			
			public Employee findByID(int id){
				String sql="select * from t_emp where id=?";
				Object[] args={id};
				Employee e=null;
				try {
					e=jt.queryForObject(sql,args,new EmpRowMapper());
				} catch (EmptyResultDataAccessException e1 ) {
					e1.printStackTrace();
					return null;
				}
					return e;
			}
			
			public void modify(Employee e){
				String sql="update t_emp set name=?,age=? where id=?";
				Object[] args={e.getName(),e.getAge(),e.getId()};
				jt.update(sql,args);
			}
			
			public void delete(int id){
				String sql="Delete from t_emp where id=?";
				Object[] args={id};
				jt.update(sql,args);
			}
			
		}

