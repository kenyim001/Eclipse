package project.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.dao.ProjectDao;
import cn.tedu.ttms.project.entity.Project;

public class ProjectTest {
	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext(
				"spring-mvc.xml",
				"spring-mybatis.xml",
				"spring-pool.xml"
				);
	}
	
	@Test
	public void testFindObjects(){
		ProjectDao dao=(ProjectDao)
		ctx.getBean("projectDao");
		List<Project> list=
		dao.findObjects();
		System.out.println(list);
		Assert.assertNotEquals(null, list);
	}
	
	/*@Test
	public void testFindPageObjects(){
		ProjectDao dao=(ProjectDao)ctx.getBean("projectDao");
		PageObject pageObject=new PageObject();
		int rowCount=dao.getRowCount(project);
		pageObject.setRowCount(rowCount);
		int pageCount=pageObject.getPageCount();
		System.out.println("pageCount="+pageCount);
		List<Project> list=dao.findPageObjects(project,pageObject);
		System.out.println(list);
		Assert.assertEquals(2, list.size());
		
	}*/
	
	//销毁context(也可以先不写)
	@After
	public void destory(){
		ctx.close();
	}
}
