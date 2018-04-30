package dao;

import java.util.List;
import java.util.Map;

import entity.Dept;
import entity.Dt;

public interface DeptDAO {
	
	public void save(Dept d);
	public List<Dept> findAll();
	public Dept findById(int id);
	public void modify(Dept d);
	public void delete(int id);
	public Map findById2(int id);
	public Dt findById3(int id);
}
