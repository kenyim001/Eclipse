package cn.tedu.proxy;

public class ProjectServiceImpl implements ProjectService{
		

		public void saveObject(Object obj) {
			System.out.println("saveObject");
			//模拟方法正在执行
			try{Thread.sleep(1000);}catch(Exception e ){
				
			}
		}

		public void updateObject(Object obj) {
			
			System.out.println("updateObjice");
			//模拟方法正在执行
			try{Thread.sleep(1000);}catch(Exception e ){
				
			}
		}
}
