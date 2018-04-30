package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
		public void service(
				HttpServletRequest req,
				HttpServletResponse res)
				throws ServletException,IOException{
				res.setContentType("text/html;utf-8");
				
				PrintWriter out=res.getWriter();
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String a=sdf.format(date);
				out.print("<p style=color:yellow;font-size:200px;font-weight:bold>"+a+"Œ“</p>");
				out.close();
		}
}
