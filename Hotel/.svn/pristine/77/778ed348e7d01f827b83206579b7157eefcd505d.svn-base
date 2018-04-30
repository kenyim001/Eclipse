package cn.tedu.hotel.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.hotel.common.exception.FindVacancyRoomNoException;
import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.dao.OffersDAO;
import cn.tedu.hotel.entity.Offer;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.entity.User;
import cn.tedu.hotel.service.OffersService;

@Service("offersService")
public class OffersServiceImpl implements OffersService{
	@Resource(name="offersDAO")
	private OffersDAO offersdao;
	
	public Map<String, Object>  findAll(PageObject pageObject) {
		List<Offer> offers=offersdao.findAll(pageObject);
		
		int rowCount=offersdao.getRowCount();
		pageObject.setRowCount(rowCount);
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("offers", offers);
		map.put("pageObject", pageObject);
		return map;
	}

	/**查找空闲房间的房号*/
	public List<Integer> findVacancyRoomNo(Room room) {
		List<Integer> roomNoList=offersdao.findVacancyRoomNo(room);
		if(roomNoList.size()==0){
			throw new FindVacancyRoomNoException("有些类型房间已满");
		}
		return roomNoList;
	}

	/**往room插入预订信息*/
	public void updateRoomInformation(Room room) {
		System.out.println("room身份证："+room.getIDNumber());
		
		System.out.println(room.getRoomStyle()+"......."+room.getBedStyle());
		List<Integer> roomNoList=offersdao.findVacancyRoomNo(room);
		Integer roomNo=roomNoList.get(0);
		System.out.println("roomNo......."+roomNo);
		room.setRoomNo(roomNo);
		int row=offersdao.updateRoomInformation(room);
		if(row==-1){
			throw new RuntimeException("预订信息提交失败");
		}
		
	}
	
	/**插入user预订信息*/
	public void insertUserInformation(User user) {
		System.out.println("user身份证："+user.getIDNumber());
		
		//生成订单号
		long orderNumber=System.currentTimeMillis();
		String htorderNumber="bzht"+orderNumber;
		user.setOrderNumber(htorderNumber);
		
		//截取密码
		String password=user.getTelephone().substring(5, 11);
		user.setPassword(password);
		
		int row=offersdao.insertUserInformation(user);
		if(row==-1){
			throw new RuntimeException("预订信息提交失败");
		}
	}

}
