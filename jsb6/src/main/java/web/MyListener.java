package web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener {

	
	
	public void requestDestroyed(ServletRequestEvent arg0) {
	System.out.println("request����");
	
	}

	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("����");
		System.out.println(e.getServletContext());
	}



}
