package ServiceTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.aop.SysRoleService;

public class RoleServiceTest {
	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-aop.xml");
	}
	@Test
	public void testSaveObject(){
		SysRoleService rService=(SysRoleService)ctx.getBean("sysRoleServiceImpl");
		Object obj=new Object();
		int rows=rService.saveObject(obj);
		Assert.assertEquals(1, rows);
	}
	
	@After
	public void destory(){
		ctx.close();
	}
	
}
