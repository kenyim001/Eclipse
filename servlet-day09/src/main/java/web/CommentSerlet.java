package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentSerlet extends HttpServlet {
       
	public void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Service begin");
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			String content=request.getParameter("content");
			out.print("ÄãµÄÆÀÂÛÊÇ£º"+content);
			System.out.println(content);
			System.out.println("Service end");
	}

}
