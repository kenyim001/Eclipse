package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

public class CountListener implements HttpSessionListener{

	/**
	 * session创建之后，会调用
	 * sessioncreated方法 
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		//先获得servletcontext
		HttpSession session=arg0.getSession();
		ServletContext sctx=session.getServletContext();
		//将在线人数绑定到servletcontext
		Integer count=(Integer) sctx.getAttribute("count");
		if(count==null){
			count=1;
		}else{
			count ++;
		}
		sctx.setAttribute("count", count);
	}

	/**
	 * session被销毁后会调用
	 * sessionDestroyed方法 
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed");
		ServletContext sctx=arg0.getSession().getServletContext();
		Integer count=(Integer)sctx.getAttribute("count");
		count --;
		sctx.setAttribute("count", count);
	}
	
	
}
