package cn.tedu.proxy;

public class ProjectServiceStaticProxy implements ProjectService{
	
		private ProjectService projectService;
		public ProjectServiceStaticProxy(ProjectService projectService) {
			this.projectService=projectService;
		}
		
	
	public void saveObject(Object obj) {
		long t1=System.currentTimeMillis();
		projectService.saveObject(obj);
		long t2=System.currentTimeMillis();
		long t=t2-t1;
		System.out.println("save"+t);
	}

	public void updateObject(Object obj) {
		long t1=System.currentTimeMillis();
		projectService.updateObject(obj);
		long t2=System.currentTimeMillis();
		long t=t2-t1;
		System.out.println("update"+t);
	}
		

}
