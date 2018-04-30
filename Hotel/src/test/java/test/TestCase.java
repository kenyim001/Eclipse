package test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.hotel.common.web.PageObject;
import cn.tedu.hotel.dao.HotelDAO;
import cn.tedu.hotel.entity.Order;
import cn.tedu.hotel.entity.Room;
import cn.tedu.hotel.entity.User;

public class TestCase {
	private HotelDAO dao;
	@Before
	public void init(){
		String config="spring.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		dao=ac.getBean("hotelDAO",HotelDAO.class);
	}
	
	@Test
	public void test1(){
		User user=dao.findByTel("18912345678");
		System.out.println(user);
		Room room=dao.findByID(user.getIDNumber());
		System.out.println(room);
	}
	@Test
	public void test6(){
	Order order=new Order();
	PageObject obj=new PageObject();
	order.setTelephone("1891234565");
	int rowCount=dao.getOrderCount(order);
	obj.setRowCount(rowCount);
	System.out.println(rowCount);
	List<Order> list=dao.findByIdOrder(order, obj);
	System.out.println(list);
		
	}
	@Test
	public void test4(){
		PageObject pageObject=new PageObject();
		Order order=new Order();
		order.setName("1");
		
		int a=dao.getOrderCount(order);
		pageObject.setRowCount(a);
		System.out.println("a:"+a);
		List<Order> list=dao.findByIdOrder(order, pageObject);
		System.out.println(list);
		for(Order o:list){
			System.out.println(o);
		}
	}
	@Test 
	public void test5(){
		String[] ab={"20170607140506103","20170607140506104"};		
		Integer valid=0;
		
		System.out.println(Arrays.toString(ab));
		System.out.println(valid);
		dao.updateValid(ab, valid);
		
	}
	@Test
	public void test8(){
		User user=new User();
		user.setName("豹子1");
		List<User> list=dao.userMsg(user);
          System.out.println(list);
	}
//	@Test
//	public void test2(){
//		
//		for(int i=1;i<10;i++){
//			String b=String.valueOf(i);
//			User user=new User("豹子"+b, "男", "14270219891202121"+b, "189123456"+b, "", "2017060714050610"+b, "无", 0, 0, "1889869124"+b, "1234", 0, 0);
//			dao.saveUser(user);
//		}
//		
//	}
	
	@Test
	public void test3() throws ParseException{
//		for(int i=101;i<=110;i++){
//			Room r=new Room(i, "标准房", "大床", 0, 199, null, null, 0, "", "");
//			dao.saveRoom(r);
//			System.out.println(r);
//		}
//		for(int i=111;i<=120;i++){
//			Room r=new Room(i, "标准房", "双人床", 0, 299, null, null, 0, "", "");
//			dao.saveRoom(r);
//			System.out.println(r);
//		}
		
//		for(int i=201;i<=210;i++){
//			Room r=new Room(i, "商务房", "大床", 0, 499, null, null, 0, "", "");
//			dao.saveRoom(r);
//			System.out.println(r);
//		}
		
//		for(int i=211;i<=220;i++){
//			Room r=new Room(i, "商务房", "双人床", 0, 599, null, null, 0, "", "");
//			dao.saveRoom(r);
//			System.out.println(r);
//		}
		
//		for(int i=301;i<=308;i++){
//			Room r=new Room(i, "豪华房", "大床", 0, 699, null, null, 0, "", "");
//			dao.saveRoom(r);
//			System.out.println(r);
//		}
		
//		for(int i=311;i<=318;i++){
//			Room r=new Room(i, "豪华房", "双人床", 0, 799, null, null, 0, "", "");
//			dao.saveRoom(r);
//			System.out.println(r);
//		}
		
//		for(int i=401;i<=405;i++){
//			Room r=new Room(i, "至尊套房", "大床", 0, 899, null, null, 0, "", "");
//			dao.saveRoom(r);
//			System.out.println(r);
//		}
		
//		for(int i=411;i<=415;i++){
			Room r=new Room();
			r.setRoomNo(419);
			r.setRoomStyle("至尊套房");
			r.setBedStyle("双人床");
			r.setCheckin(new Date());
			r.setCheckout(new Date());
			r.setOriginalPrice(999.0);
			r.setPersonCount(0);
			r.setState(0);
			r.setIDNumber("440184199108077149");
			r.setRemarks("无");
			dao.saveRoom(r);
			System.out.println(r);
//		}
	}
	
	
	
}
