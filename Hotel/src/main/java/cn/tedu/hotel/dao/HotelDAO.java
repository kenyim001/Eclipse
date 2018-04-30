package cn.tedu.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.entity.Order;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.entity.User;


public interface HotelDAO {
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
	
	/**查看所有信息*/
	public List<Order> findOrder(@Param("pageObject")PageObject pageObject);
	
	public int getOrderCount(@Param("Order")Order order);
	/**根据用户名查询信息*/
	public List<Order> findByIdOrder(@Param("Order")Order order,@Param("pageObject")PageObject pageObject);
	
	public int getRowCount();
	
	/**更新订单有效状态*/
	public int updateValid(@Param("ids")String[] ids,@Param("Valid")Integer valid);
	/*
	 * 根据roomStyle查询房间-bao
	 */
	public Room[] findByRoomStyle(String roomStyle);

	
	//修改信息
	public int modifyUser(User user);

	/**用户查询订单*/
	public List<User> userMsg(@Param("User")User user);

}
