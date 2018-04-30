package cn.tedu.ttms.product.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.tedu.ttms.product.dao.ProductTypeDao;
import cn.tedu.ttms.product.entity.ProductType;
import cn.tedu.ttms.product.service.ProductTypeService;
@Service
public class ProductTypeServiceImpl implements ProductTypeService{
	@Resource
	private ProductTypeDao productTypeDao;
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> map=productTypeDao.findObjects();
		System.out.println(map);
		return map;
	}
	@Override
	public List<Map<String, Object>> findTreeNodes() {
		List<Map<String, Object>> map=
		productTypeDao.findTreeNodes();
		System.out.println(map);
		return map;
	}
	@Override
	public void saveObject(ProductType type) {
		int rows=productTypeDao.insertObject(type);
		if(rows==-1)throw new RuntimeException("insert error");
	}
	@Override
	public void updateObject(ProductType type) {
		int rows=productTypeDao.updateObject(type);
		if(rows==-1)throw new RuntimeException("update error");
	}
	
	@Override
	public Map<String, Object> findObjectById(Integer id) {
		if(id==null)throw new RuntimeException("id can not be null");
		return productTypeDao.findObjectById(id);
	}
	
	@Override
	public void deleteObjectById(Integer id) {
		if(id==null)throw new RuntimeException("id can not be null");
		int count=productTypeDao.hasChildObject(id);
		if(count>0)throw new RuntimeException("请删除子类");
		int rows=productTypeDao.deleteObjectById(id);
		if(rows==-1)throw new RuntimeException("delete error");
	}
	
}
