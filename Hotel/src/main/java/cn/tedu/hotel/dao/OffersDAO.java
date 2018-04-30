package cn.tedu.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.entity.Offer;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.entity.User;

public interface OffersDAO {
	/**获取Offers*/
	public List<Offer> findAll(@Param("pageObject")PageObject pageObject);
	
	
	/**获取roomStyle和bedStyle组的总记录数*/
	public int getRowCount();
	
	/**查找空闲房间的房号*/
	public List<Integer> findVacancyRoomNo(Room room);
	
	
	/**往room插入预订信息*/
	public int updateRoomInformation(Room room);
	
	/**插入user预订信息*/
	public int insertUserInformation(User user);
	
}
