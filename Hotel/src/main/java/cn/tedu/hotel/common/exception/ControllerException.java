package cn.tedu.hotel.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.hotel.common.web.JsonResult;

/**
 * 这是我在这里测试
 */

/**异常处理类*/
@ControllerAdvice
public class ControllerException {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult handleException(Exception e){
		System.out.println("Exception.....");
		e.printStackTrace();
		return new JsonResult(e);
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult handleException(RuntimeException e){
		
		return new JsonResult(e);
	}
	
	@ExceptionHandler(FindVacancyRoomNoException.class)
	@ResponseBody
	public JsonResult handleException(FindVacancyRoomNoException e){
		System.out.println(e.getMessage());
		return new JsonResult(e);
	}
}
