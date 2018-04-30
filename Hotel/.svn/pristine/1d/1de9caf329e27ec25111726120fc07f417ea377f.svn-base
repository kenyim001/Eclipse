package cn.tedu.hotel.service;

import java.util.List;
import java.util.Map;

import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.entity.Offer;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.entity.User;

public interface OffersService {
	public Map<String, Object> findAll(PageObject pageObject);
	
	/**查找空闲房间的房号*/
	public List<Integer> findVacancyRoomNo(Room room);
	
	
	
	/**往room插入预订信息*/
	public void updateRoomInformation(Room room);
	
	/**插入user预订信息*/
	public void insertUserInformation(User user);
}
