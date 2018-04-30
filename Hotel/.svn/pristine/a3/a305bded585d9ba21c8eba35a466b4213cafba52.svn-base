package cn.tedu.hotel.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.dao.HotelDAO;
import cn.tedu.hotel.entity.Order;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.entity.User;
import cn.tedu.hotel.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService{
    @Resource
	private HotelDAO hotelDao;
    
    public User findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	public Room findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void saveRoom(Room room) {
		// TODO Auto-generated method stub
		
	}

	public User modify(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	public Map<String,Object> findOrder(PageObject pageObject) {
		List<Order> orderList=hotelDao.findOrder(pageObject);
	
		int rowCount=hotelDao.getRowCount();
		
	
		pageObject.setRowCount(rowCount);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", orderList);
		map.put("pageObject", pageObject);
		return map;
	}

	public Map<String, Object> findByIdOrder(Order order, PageObject pageObject) {
		
		List<Order> idList=hotelDao.findByIdOrder(order, pageObject);
		
		int rowCount=hotelDao.getOrderCount(order);
		
		pageObject.setRowCount(rowCount);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("idList", idList);
		map.put("pageObject", pageObject);
		return map;
	}

	public void updateValid(String checkedIds, Integer valid) {
		String[] ids=checkedIds.split(",");			
		 hotelDao.updateValid(ids, valid);	
	}

	public Map<String,Object> userMsg(User user) {
		  List<User> list=hotelDao.userMsg(user);
		  Map<String,Object> map=new HashMap<String,Object>();
		  map.put("user", list);		  
		return map;
	}
   
	
	
 
	
}
