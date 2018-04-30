package cn.tedu.hotel.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.hotel.common.web.JsonResult;
import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.entity.User;
import cn.tedu.hotel.service.OffersService;

@Controller
public class OffersController {
	@Resource(name="offersService")
	private OffersService offersservice;
	
	
	@RequestMapping("/offersUI")
	public String offersUI(){
		return "offers";
	}
	
	
	@RequestMapping("/offers")
	@ResponseBody
	public JsonResult findAllRoom(PageObject pageObject){
		Map<String, Object> map=offersservice.findAll(pageObject);
		return new JsonResult(map);
	}
	
	@RequestMapping("/information_form")
	public String information_form(){
		return "common/information_form";
	}
	
	
	/**查找空闲房间的房号*/
	@RequestMapping("/doFindVacancyRoomNo")
	@ResponseBody
	public JsonResult doFindVacancyRoomNo(Room room){
		List<Integer> roomNoList=offersservice.findVacancyRoomNo(room);
		return new JsonResult(roomNoList);
	}
	
	
	
	
	/**插入user预订信息*/
	@RequestMapping("/doInsertUserInformation")
	@ResponseBody
	public JsonResult doInsertUserInformation(User user){
		offersservice.insertUserInformation(user);
		return new JsonResult();
	}
	
	
	/**往room插入预订信息*/
	@RequestMapping("/doUpdateRoomInformation")
	@ResponseBody
	public JsonResult doUpdateRoomInformation(Room room){
		offersservice.updateRoomInformation(room);
		return new JsonResult();
	}
	
}
