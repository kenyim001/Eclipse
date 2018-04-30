package com.tz.lxr;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.swetake.util.Qrcode;

import java.io.PrintWriter;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QrcodeLxr extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//1.引入 import com.swetake.util.Qrcode;
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		//2.创建Qrcodede的句柄
		Qrcode qrhand = new Qrcode();
		
		//3.设置纠错级别
		qrhand.setQrcodeErrorCorrect('M');//qrcode官网查询
		
		//4.设置编码模式：二进制
		qrhand.setQrcodeEncodeMode('B');
		
		//5.设置版本1-40 version
		qrhand.setQrcodeVersion(15);//qrcode官网查询
		
		//6.获取图片缓冲对象 
		//定义二维码图片的宽和高
		int width=235,height=235;//15版本生成的大小
		//创建图片对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//7.获取制图工具
		Graphics2D grap = image.createGraphics();
		//设置二维码图片的背景色
		grap.setBackground(Color.WHITE);
		grap.clearRect(0, 0, width, height);
		//设置画笔颜色
		grap.setColor(Color.BLACK);
		
		//8.写入内容生成二维码图片
		//request.getParameter
		String content = request.getParameter("content");
		//获取内容的字节数组
		byte[] contentBytes = content.getBytes("gbk");
		//通过Qrcode获取二维数组  1 0
		boolean[][] codeOut = qrhand.calQrcode(contentBytes);
		//遍历二维数组，获取值，生成二维码
		for(int i=0;i<codeOut.length;i++){
			for(int j=0;j<codeOut.length;j++){
				if(codeOut[j][i]){//1画0不画绘制方块
					grap.fillRect(j*3+2,i*3+2,3,3);
					
				}
			}
		}
		//释放资源
		grap.dispose();
		image.flush();
		String fileName = UUID.randomUUID()+".png";
		File file = new File(this.getServletContext().getRealPath("/qrcode")+"/"+fileName);
		//ImageIO.write(image, "png", response.getOutputStream());
		ImageIO.write(image, "png", file);
		System.out.println(content);
		response.getWriter().print(fileName);
		
	}
	

}
