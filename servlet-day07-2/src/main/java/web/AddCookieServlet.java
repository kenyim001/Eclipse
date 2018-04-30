package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Cookie c=new Cookie("username",URLEncoder.encode("¿Ó","utf-8"));
			Cookie c2=new Cookie("city","gz");
			c.setMaxAge(10);
			
			response.addCookie(c);
			response.addCookie(c2);
		}

}
