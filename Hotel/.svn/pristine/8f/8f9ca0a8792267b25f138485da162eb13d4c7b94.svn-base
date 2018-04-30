package cn.tedu.hotel.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.hotel.common.web.JsonResult;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.service.IndexService;

@Controller
public class IndexController {
	@Resource(name="indexService")
	private IndexService indexService;
	
	/**
	 * 首页展示
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	@RequestMapping("/showIndex")
	@ResponseBody
	public JsonResult showIndex(){
		Map<String,Object> map = indexService.showNormalRoom();
		return new JsonResult(map);
	}
	
	/**
	 * 房间展示
	 * @return
	 */
	@RequestMapping("/rooms")
	public String rooms(){
		return "rooms";
	}
	@RequestMapping("/showRooms")
	@ResponseBody
	public JsonResult showRooms(){
		Map<String,Object> map = indexService.showNormalRoom();
		return new JsonResult(map);
	}
	
	/**
	 * 预订展示
	 * @return
	 */
	@RequestMapping("/details")
	@ResponseBody
	public String details(){
		return "details";
	}
	/*@RequestMapping("/showDetails")
	@ResponseBody
	public JsonResult showDetails(){
		Map<String,Object> map = indexService.showNormalRoom();
		return new JsonResult(map);
	}*/
	
	
	//首页点击预订传递信息给预订界面
/*	@RequestMapping("/details.do")
	@ResponseBody
	public String bookRoom(Room room,ModelMap mm,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		String price = String.valueOf(room.getOriginalPrice());
		room = indexService.showNormalRoom();
		System.out.println(room.getRoomStyle());
		mm.addAttribute("rrr",room);
		System.out.println(mm);
		return "details";
	}*/
	
	
}
