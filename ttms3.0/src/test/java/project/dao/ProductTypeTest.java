package project.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.product.dao.ProductTypeDao;

public class ProductTypeTest {

	ClassPathXmlApplicationContext ctx;
	@Before 
	public void initCtx(){
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml","spring-pool.xml","spring-mybatis.xml");
	}
	@After
	public void closeCtx(){
		ctx.close();
	}
	@Test
	public void testFindObjects() {
		ProductTypeDao dao=(ProductTypeDao) ctx.getBean("productTypeDao");
		
		
		
	}
}
