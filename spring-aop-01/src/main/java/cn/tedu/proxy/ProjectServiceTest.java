package cn.tedu.proxy;

public class ProjectServiceTest {

	public static void main(String[] args) {
		ProjectService projectService;
		ProjectServiceImpl projectServiceImpl=new ProjectServiceImpl();
		Object obj=new Object();
		projectServiceImpl.saveObject(obj);
		projectServiceImpl.updateObject(obj);
		projectService=new ProjectServiceStaticProxy(projectServiceImpl);
		projectService.saveObject(projectService);
		projectService.updateObject(projectService);
	}

}
