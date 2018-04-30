package cn.tedu.hotel.service.impl;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.hotel.dao.HotelDAO;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.service.IndexService;
/**
 * 业务层 
 * 首页数据实现
 * @author soft01
 *
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService{
	@Resource(name="hotelDAO")
	private HotelDAO dao;
	public Map<String,Object> showNormalRoom() {
		Room[] room1 = null;
		Room[] room2 = null;
		Room[] room3 = null;
		Room[] room4 = null;
		Map<String,Object> map = new HashMap<String, Object>();
		
		
		try {
			room1 = dao.findByRoomStyle("标准房");
			if(room1.length>0){
				System.out.println(room1[0]);
				map.put("normal", room1[0]);
			}else{
				System.out.println("标准房没有房间");
			}
			
			room2 = dao.findByRoomStyle("豪华房");
			if(room2.length>0){
				System.out.println(room2[0]);
				map.put("luxury", room2[0]);
			}else{
				System.out.println("豪华房没有房间");
			}
			
			room3 = dao.findByRoomStyle("商务房");
			if(room3.length>0){
				System.out.println(room3[0]);
				map.put("business", room3[0]);
			}else{
				System.out.println("豪华房没有房间");
			}
			
			room4 = dao.findByRoomStyle("至尊套房");
			if(room4.length>0){
				System.out.println(room4[0]);
				map.put("flatlet", room4[0]);
			}else{
				System.out.println("至尊套房没有房间");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return map;
	}
	/*
	public Room showLuxuryRoom() {
		Room[] room = null;
		try {
			room = dao.findByRoomStyle("豪华房");
			
			if(room.length>0){
				System.out.println(room[0]);
			}else{
				System.out.println("没有房间");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return room[0];
	}
	public Room showBusinessRoom() {
		Room[] room = null;
		try {
			room = dao.findByRoomStyle("商务房");
			
			if(room.length>0){
				System.out.println(room[0]);
			}else{
				System.out.println("没有房间");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return room[0];
	}
	public Room showFlatletRoom() {
		Room[] room = null;
		try {
			room = dao.findByRoomStyle("至尊套房");
			
			if(room.length>0){
				System.out.println(room[0]);
			}else{
				System.out.println("没有房间");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return room[0];
	}
	*/
}
