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
    		 * step1����ͼƬ
    		 */
    		//����һ������
    			BufferedImage img=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
    		//��û���
    			Graphics g=img.getGraphics();
    			//����������ɫ
    			g.setColor(new Color(255, 255, 255));
    			//���û���������ɫ��Χ
    			g.fillRect(0, 0, 80, 30);
    			//����������ɫ
    			Random  r=new Random();
    			g.setColor(new Color(
    					r.nextInt(255), 
    					r.nextInt(255), 
    					r.nextInt(255)));
    			//��������
    			g.setFont(new Font(null,Font.BOLD,24));
    			//����һ�������
    			String number=getNumber(5);
    			//��ͼƬ�ϻ��������
    			g.drawString(number, 2, 25);//���½�����
    			
    			//��
    			HttpSession session=request.getSession();
    			session.setAttribute("number",number);
    			
    			//������
    			for (int i = 0; i < 8; i++) {
    				g.setColor(new Color(
        					r.nextInt(255), 
        					r.nextInt(255), 
        					r.nextInt(255)));
					g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), 30);
				}
    			
    		/**
    		 * step2 ѹ��ͼƬ�����jpeg
    		 */
    			//��������������������ص���һ��ͼƬ
    			response.setContentType("image/jpeg");
    			//Ҫ����ֽ������
    			OutputStream output=response.getOutputStream();
    			//��ԭʼͼƬ����ָ���ĸ�ʽ ��jpeg������ѹ����Ȼ�����
    			javax.imageio.ImageIO.write(img, "jpeg", output);
    			output.close();
    			
    }
    	/**
    	 * 
    	 * ����Ϊsize���ַ��������A-z,0-9��ѡȡ
    	 * ���ַ���
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
