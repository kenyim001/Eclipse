package cn.tedu.hotel.controller;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.hotel.common.web.JsonResult;
import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.entity.Order;
import cn.tedu.hotel.entity.User;
import cn.tedu.hotel.service.HotelService;

@Controller

public class HotelController {
	
	@Resource
	private HotelService hotelService;
	
	@RequestMapping("/hotelUI")
	public String hotelUI(){
		
		
		/*return "hotel/order";*/
		return "order";
	}
	@RequestMapping("/userUI")
	public String userUI(){
		
		
		/*return "hotel/order";*/
		return "user";
	}
	
	/**查询订单*/
	@RequestMapping("/findOrderMsg")
	@ResponseBody
	public JsonResult findOrderMsg(PageObject pageObject){
	
		Map<String,Object> map=hotelService.findOrder(pageObject);
		
		return new JsonResult(map);
	}
	/**根据姓名查询订单信息*/
	@RequestMapping("/findOrderNameMsg")
	@ResponseBody
	public JsonResult findByNameOrder(Order order,PageObject pageObject){
		Map<String,Object> map=hotelService.findByIdOrder(order, pageObject);
		
		return new JsonResult(map);	
	}
	
	/**更新订单有效无效信息*/
	@RequestMapping("/updateValid")
	@ResponseBody
	public JsonResult updateValid(String checkedIds,Integer valid){
		
		hotelService.updateValid(checkedIds, valid);
		return new JsonResult();
	}
	
	@RequestMapping("/userMsg")
	@ResponseBody
	public JsonResult userMsg(User user){
		Map<String,Object> map=hotelService.userMsg(user);
		return new JsonResult(map);
	}
	
}
