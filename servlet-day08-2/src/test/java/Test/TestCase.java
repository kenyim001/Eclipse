package Test;

import org.junit.Test;

import dao.UserDao;
import entity.User;

public class TestCase {
		@Test
		public void tset1(){
			UserDao dao=new UserDao();
			User user=dao.findByUsername("Sally");
			System.out.println(user);
		}
}
