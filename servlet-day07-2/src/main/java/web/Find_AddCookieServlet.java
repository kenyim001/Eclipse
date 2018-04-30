package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_AddCookieServlet extends HttpServlet {
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Cookie[] cookies=request.getCookies();
		
		if(cookies ==null){
				out.println("cookieΪ�գ������");
				Cookie c=new Cookie("cart",URLEncoder.encode("��","utf-8"));
				response.addCookie(c);
		}else{
			boolean flag=true;
			for (int i = 0; i < cookies.length; i++) {
				Cookie c=cookies[i];
				String name=c.getName();
				if ("cart".equals(name)) {
					String value=URLDecoder.decode(c.getValue(),"utf-8");
					out.print(value);
					flag=false;
					break;
				}
			}if(flag=true){
				Cookie c=new Cookie("cart",URLEncoder.encode("��","utf-8"));
				response.addCookie(c);
			}
			
		}
	}
}
