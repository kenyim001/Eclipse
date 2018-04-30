package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet extends HttpServlet {
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡsession����
		HttpSession session=request.getSession(true);
		String sessionId=session.getId();
		System.out.println("sessionId:"+sessionId);
		HttpSession s=request.getSession();
//		����HttpSession session=request.getSession(true);
		Integer count=(Integer) session.getAttribute("count");
		session.setMaxInactiveInterval(20);
		if(count==null){
			//��һ��
			count=1;
		}else{
			//���ǵ�һ��
			count ++;
		}
		session.setAttribute("count", count);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("��ϵ��"+count+"�η����ˣ��㵽�����");
		//ɾ��session
//		session.invalidate();
	}
		
}
