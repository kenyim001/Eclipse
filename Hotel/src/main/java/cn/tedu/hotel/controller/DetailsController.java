package cn.tedu.hotel.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.hotel.entity.Offer;
import cn.tedu.hotel.service.DetailsService;

@Controller
public class DetailsController {
	@Resource(name="detailsService")
	private DetailsService detailsService;
	
	
	@RequestMapping("/details.do")
	public String toBook(Offer offer,HttpServletRequest request){
		System.out.println(offer.getRoomStyle()+" "+offer.getBedStyle()+" "+offer.getOriginalPrice());
		request.setAttribute("offer", offer);
		return "details";
	}
	
	
	/**
	 * 异步请求 roomStyle或bedStyle变化后更新价格
	 */
	@RequestMapping("/getPrice.do")
	@ResponseBody
	public Offer getPrice(Offer offer,HttpServletRequest request){
		System.out.println(offer);
		Offer o=detailsService.getPrice(offer);
		return o;
	}
	
	
	/**
	 * 检查输入的验证码是否正确
	 */
	@RequestMapping("/checkcode.do")
	@ResponseBody
	public Map checkcode(HttpServletRequest request,HttpSession session){
		Map<String, String> map=new HashMap<String, String>();
		
		String inputNumber=request.getParameter("number");//用户输入的
		String number=(String) session.getAttribute("number");//预先绑定在session上的
		
		if(!inputNumber.toUpperCase().equals(number)){
			map.put("error_code", "验证码输入有误");
		}
		
		return map;
	}
	
	
	/**
	 * 验证的生成
	 */
	@RequestMapping("/generatecheckcode.do")
	public void checkcode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		/*
		 * step1 生成图片  
		 */
		//创建一个画布
		BufferedImage image = 
				new BufferedImage(
				85,30,BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics g = 
				image.getGraphics();
		//给笔设置颜色
		g.setColor(new Color(255,255,255));
		//设置画布背景颜色
		g.fillRect(0, 0, 85, 30);
		//重新给笔设置颜色
		Random r = new Random();
		g.setColor(new Color(
				r.nextInt(255),
				r.nextInt(255),
				r.nextInt(255)));
		//设置字体
		g.setFont(new Font(null,Font.BOLD,24));
		//生成一个随机数（验证码）
		String number = getNumber(5);
		
		//将验证码绑订到session对象上
		HttpSession session = 
				request.getSession();
		session.setAttribute("number", number);
		
		//在图片上绘制随机数
		g.drawString(number, 2, 25);
		
		//添加干扰线
		for(int i = 0; i < 8; i ++){
			g.setColor(new Color(
					r.nextInt(255),
					r.nextInt(255),
					r.nextInt(255)));
			g.drawLine(r.nextInt(80), 
					r.nextInt(30), r.nextInt(80),
					r.nextInt(30));
		}
		
		
		/*
		 * step2 压缩图片并输出
		 * 	  
		 */
		//告诉浏览器，服务器返回的是一张图片
		response.setContentType("image/jpeg");
		//要获得字节输出流。
		OutputStream output = 
				response.getOutputStream();
		//将原始图片按照指定的格式(jpeg)进行
		//压缩，然后输出。
		javax.imageio.ImageIO
		.write(image, "jpeg", output);
		output.close();
	}

	/*
	 * 生成长度为size个字符（随机从A~Z,0~9中选取）
	 * 的字符串。
	 */
	private String getNumber(int size){
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "0123456789";
		String number = "";
		Random r  = new Random();
		for(int i = 0;i < size; i++){
			number += chars.charAt(
					r.nextInt(chars.length()));
		}
		return number;
	}

	
	
}
