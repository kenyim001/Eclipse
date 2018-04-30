package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

public class CountListener implements HttpSessionListener{

	/**
	 * session����֮�󣬻����
	 * sessioncreated���� 
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		//�Ȼ��servletcontext
		HttpSession session=arg0.getSession();
		ServletContext sctx=session.getServletContext();
		//�����������󶨵�servletcontext
		Integer count=(Integer) sctx.getAttribute("count");
		if(count==null){
			count=1;
		}else{
			count ++;
		}
		sctx.setAttribute("count", count);
	}

	/**
	 * session�����ٺ�����
	 * sessionDestroyed���� 
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed");
		ServletContext sctx=arg0.getSession().getServletContext();
		Integer count=(Integer)sctx.getAttribute("count");
		count --;
		sctx.setAttribute("count", count);
	}
	
	
}
