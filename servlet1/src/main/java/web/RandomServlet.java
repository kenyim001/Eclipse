package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	int ran = (int)(Math.random()*100+1);
	    	res.setContentType("text/html");
	    	PrintWriter w=res.getWriter();
	    	w.println("<p>"+ran+"</p>");
	    	w.close(); 
	}

}
