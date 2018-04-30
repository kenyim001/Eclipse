package cn.tedu.hotel.service;

import java.util.List;
import java.util.Map;

import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.entity.Order;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.entity.User;

public interface HotelService {
    
    //根据手机号查询预订信息
  	public User findByTel(String tel);
  	
  	//根据身份证号查询房间
  	public Room findByID(String id);
  	
  	//添加客户信息
  	public void saveUser(User user);
  	
  	//添加房间预订信息
  	public void saveRoom(Room room);
  	
  	//修改预订信息
  	public User modify(String id);
  	
  	//取消预订(删除预订信息)
  	public void delete(String id);
  	
  	//查看所有订单
  	public Map<String,Object> findOrder(PageObject pageobejct);
  	
  	//根据姓名查看订单
  	public Map<String,Object> findByIdOrder(Order order, PageObject pageObject);
    
  	/**启用/禁用订单*/
  	public void updateValid(String checkedIds,Integer valid);
  	
  	/**用户查询订单*/
  	public Map<String,Object> userMsg(User user);
}
