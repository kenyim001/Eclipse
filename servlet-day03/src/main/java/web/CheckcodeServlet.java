package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckcodeServlet extends HttpServlet {
    public void service(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
    		System.out.println("checkcode...");
    		/**
    		 * step1生成图片
    		 */
    		//创建一个画布
    			BufferedImage img=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
    		//获得画笔
    			Graphics g=img.getGraphics();
    			//给笔设置颜色
    			g.setColor(new Color(255, 255, 255));
    			//设置画布背景颜色范围
    			g.fillRect(0, 0, 80, 30);
    			//给笔设置颜色
    			Random  r=new Random();
    			g.setColor(new Color(
    					r.nextInt(255), 
    					r.nextInt(255), 
    					r.nextInt(255)));
    			//设置字体
    			g.setFont(new Font(null,Font.BOLD,24));
    			//生成一个随机数
    			String number=getNumber(5);
    			//将图片上绘制随机数
    			g.drawString(number, 2, 25);//左下角坐标
    			
    			//绑定
    			HttpSession session=request.getSession();
    			session.setAttribute("number",number);
    			
    			//设置线
    			for (int i = 0; i < 8; i++) {
    				g.setColor(new Color(
        					r.nextInt(255), 
        					r.nextInt(255), 
        					r.nextInt(255)));
					g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), 30);
				}
    			
    		/**
    		 * step2 压缩图片并输出jpeg
    		 */
    			//告诉浏览器，服务器返回的是一张图片
    			response.setContentType("image/jpeg");
    			//要获得字节输出流
    			OutputStream output=response.getOutputStream();
    			//将原始图片按照指定的格式 （jpeg）进行压缩，然后输出
    			javax.imageio.ImageIO.write(img, "jpeg", output);
    			output.close();
    			
    }
    	/**
    	 * 
    	 * 长度为size个字符，随机从A-z,0-9中选取
    	 * 的字符串
    	 */
    		public String getNumber(int size){
    			String chars="ABCDEFGHIJKLNMOPQRSTUVWYZ"
    					+ "0123456789";
    			String number="";
    			Random r=new Random();
    			for (int i = 0; i < size; i++) {
					number+=chars.charAt(r.nextInt(chars.length()));
				}
    			return number;
    		}
}
