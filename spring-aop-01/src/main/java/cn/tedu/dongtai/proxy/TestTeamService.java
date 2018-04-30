package cn.tedu.dongtai.proxy;

import cn.tedu.proxy.ProjectService;
import cn.tedu.proxy.ProjectServiceImpl;

public class TestTeamService {
    public static void main(String[] args) {
		TeamService tService=
				new TeamServiceImpl();
		Object obj=new Object();
		tService.save(obj);
		tService.update(obj);
		
		
		ProxyHandler proxyHandler=new ProxyHandler();
		TeamService proxyObject=(TeamService)proxyHandler.newProxy(tService);
		
		proxyObject.save(proxyObject);
		proxyObject.update(proxyObject);
		
		
		ProjectService pService=new ProjectServiceImpl();
	}
}
