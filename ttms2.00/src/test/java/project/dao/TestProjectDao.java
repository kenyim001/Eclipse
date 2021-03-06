package project.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.dao.ProjectDao;
import cn.tedu.ttms.project.entity.Project;
public class TestProjectDao {
	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext(
		"spring-mvc.xml",
		"spring-pool.xml",
		"spring-mybatis.xml");
	}
	
	@Test
	public void testInsertObject()throws Exception{
		//1.获得ApplicationContext对象

		//2.获得DAO对象
		ProjectDao projectDao=
		(ProjectDao)ctx.getBean("projectDao");
		//3.构建entity对象
		Project entity=new Project();
		entity.setId(null);
		entity.setCode("TT-20170711-CHN-SH-001");
		entity.setName("中国钻石游");
		SimpleDateFormat sdf=
		new SimpleDateFormat("yyyy-MM-dd");
		entity.setBeginDate(sdf.parse("2017-07-19"));
		entity.setEndDate(sdf.parse("2017-08-19"));
		entity.setValid(1);
		entity.setNote("中国钻石游....");
		entity.setCreatedUser("admin");
		entity.setModifiedUser("admin");
		//4.将对象写入到数据库
		int n=projectDao.insertObject(entity);
		Assert.assertEquals(1, n);
	}
	/**测试查询操作*/
	@Test
	public void testFindObjects(){
		ProjectDao dao=(ProjectDao)
		ctx.getBean("projectDao");
		List<Project> list=
		dao.findObjects();
		System.out.println(list);
		Assert.assertNotEquals(null, list);
	}
	@Test
	public void testFindPageObjects(){
		ProjectDao dao=(ProjectDao)
				ctx.getBean("projectDao");
		PageObject pageObject=//startIndex=0,pageSize=2;
		new PageObject();
		Project project=new Project();
		//总记录数
		int rowCount=dao.getRowCount(project);
		//获得总页数(根据总记录数,pageSize计算总页数)
		pageObject.setRowCount(rowCount);
		int pageCount=pageObject.getPageCount();

		System.out.println("pageCount="+pageCount);
		//获得当前页的记录(当前页为1)

		List<Project> list=dao.
		findPageObjects(project,pageObject);
		System.out.println(list);
		Assert.assertEquals(2, list.size());
	}
	
	
	//销毁context(也可以先不写)
	@After
	public void destory(){
		ctx.close();
	}
}
//DB-->ProjectMapper.xml-->ProjectDao-->ProjectService--->ProjectController-->页面





