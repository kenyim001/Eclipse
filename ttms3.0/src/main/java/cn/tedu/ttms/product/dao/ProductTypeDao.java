package cn.tedu.ttms.product.dao;

import java.util.List;
import java.util.Map;
import cn.tedu.ttms.product.entity.ProductType;

public interface ProductTypeDao {

	List<Map<String,Object>> findObjects();
	List<Map<String,Object>> findTreeNodes();
	int insertObject(ProductType type);
	int updateObject(ProductType type);
	Map<String,Object> findObjectById(Integer id);
	int deleteObjectById(Integer id);
	int hasChildObject(Integer id);
	
}
