package test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.dao.OffersDAO;
import cn.tedu.hotel.entity.Offer;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.entity.User;

public class TestOffers {
	private OffersDAO offersdao;
	@Before
	public void init(){
		String config="spring.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		offersdao=ac.getBean("offersDAO",OffersDAO.class);
	}
	
	@Test
	//测试 Offers findAll()方法
	public void findAll(){
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(8);
		List<Offer> offers=offersdao.findAll(pageObject);
		for(Offer o:offers){
			System.out.println(o);
		}
	}
	
	@Test
	//测试 Offers getRowsCount()方法
	public void getRowsCount(){
		int rowsCount=offersdao.getRowCount();
		System.out.println(rowsCount);
	}
	
	@Test
	public void testFindVacancyRoomNo(){
		Room room=new Room();
		room.setRoomStyle("豪华房");
		room.setBedStyle("双人床");
		List<Integer> roomNoList=offersdao.findVacancyRoomNo(room);
		System.out.println(roomNoList);
		Assert.assertNotEquals(null, roomNoList);
	}
	
	@Test
	public void testOrderNumber(){
		long number=System.currentTimeMillis();
		String orderNumber=number+"";
		System.out.println(orderNumber);
	}
	
	@Test
	public void testUpdateRoomInformation(){
		Room room=new Room();
		room.setCheckin(new Date());
		room.setCheckout(new Date());
		room.setPersonCount(2);
		room.setIDNumber("440185200008017123");
		room.setState(1);
		room.setRoomNo(301);
		
		int row=offersdao.updateRoomInformation(room);
		System.out.println(row);
		Assert.assertEquals(1, row);
	}
	
	@Test
	public void testInsertUserInformation(){
		User user=new User();
		user.setName("辉哥");
		user.setPassword("124564");
		
		user.setIDNumber("440185200008017129");
		user.setTelephone("15874653209");
		user.setRemarks("订房啊");
		int row=offersdao.insertUserInformation(user);
		System.out.println(row);
		Assert.assertEquals(1, row);
	}
	
	
}
