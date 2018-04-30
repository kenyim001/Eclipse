package cn.tedu.ssh1.action;
	/**struts 的子控制器*/
public class DemoAction {
		// 控制器中，处理web请求的方法默认情况下有execute
		//方法的返回值是字符串，值是目标视图的名称
	
	public String execute(){
		//调用业务模型，调用业务层
		System.out.println("hello world");
		return "success"; //反馈给用户的视图名
	}
}
