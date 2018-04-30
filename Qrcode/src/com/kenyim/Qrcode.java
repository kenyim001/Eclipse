package com.kenyim;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 
 */

public class Qrcode {
	
			/*————二维码基本信息设置———— */
		public static void getOrcodeImg(String content,String imgPath){
			//实例化一个Qrcode对象
			com.swetake.util.Qrcode qrcode=new com.swetake.util.Qrcode();
			//设置二维码的排错率M 15%
			qrcode.setQrcodeErrorCorrect('M');
			//编 码 B国际编码
			qrcode.setQrcodeEncodeMode('B');
			//二维码的版本
			qrcode.setQrcodeVersion(15);
			
			 /*———开始绘制二维码———*/
			int width=235;
			int height=235;
			//画板 
			BufferedImage image=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
			//画笔
			Graphics2D gs=image.createGraphics();
			//设置画板背景色
			gs.setBackground(Color.white);
			//设定绘制的区域
			gs.clearRect(0, 0, width, height);
			//设置画笔的颜色
			gs.setColor(Color.black);
			 
			//拿到信息 content
			byte[] codeOut;
			try {
				codeOut=content.getBytes("utf-8");
				boolean[][] code=qrcode.calQrcode(codeOut);
				//拿到二维数组里的内容
				for (int i = 0; i < code.length; i++) {
					for (int j = 0; j < code.length; j++) {
						if(code[i][j]){//判断信息真假 如果是真的就绘制
							gs.fillRect(i*3+2, j*3+2, 3, 3);
							
						}
					}
				}
				//释放资源
				gs.dispose();
				image.flush();
				
				//保存、
				ImageIO.write(image, "png", new File(imgPath));
				System.out.println("二维码生成成功");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	 

	
	
	public static void main(String[] args) {
		getOrcodeImg("BEGIN:VCARD\nFN:任侠 \nTITLE:123\nEND:VCARD","D:/软件/1.png");
	}
	
}
