package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.hotel.dao.DetailsDAO;
import cn.tedu.hotel.entity.Offer;

public class TestDetails {
	private DetailsDAO detailsDAO;
	@Before
	public void init(){
		String config="spring.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		detailsDAO=ac.getBean("detailsDAO",DetailsDAO.class);
	}
	
	@Test
	public void test1(){
		Offer o=new Offer();
		o.setRoomStyle("豪华房");
		o.setBedStyle("大床");
		Offer offer=detailsDAO.getPrice(o);
		System.out.println(offer);
	}
}
