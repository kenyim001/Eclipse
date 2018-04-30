package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bmi extends HttpServlet  {
	public void service(HttpServletRequest req,
			HttpServletResponse res)
			throws ServletException,IOException{
	double wegiht=Double.parseDouble(req.getParameter("wegiht"));
	double height=Double.parseDouble(req.getParameter("height"));
	  
	double bmi=Math.round(wegiht/height/height);
	res.setContentType("text/html;charset=utf-8");
	PrintWriter out=res.getWriter();
	out.println("bmiÖ¸Êý:"+bmi);
	out.close();
	}
}