package web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener {

	
	
	public void requestDestroyed(ServletRequestEvent arg0) {
	System.out.println("requestÏú»Ù");
	
	}

	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("´´½¨");
		System.out.println(e.getServletContext());
	}



}
