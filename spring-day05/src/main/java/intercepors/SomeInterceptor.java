package intercepors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements
	HandlerInterceptor{
	/**
	 * 最后执行的方法
	 * 注(了解)：
	 * arg3是处理器方法所抛出的异常
	 * 
	 */
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
		
	}

	/**
	 * 处理器(controller)的方法已经执行完毕正准备将处理结果（modelAndView）返回给DispatcherServlet
	 *  之前执行postHandle方法
	 *  注：可以在该方法里面，修改ModelAndView
	 */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("psotHandle()");
		
	}
	
	/**
	 * DispatcherServlet在收到请求之后会先调用拦截器的preHandle方法
	 * 如果该方法的返回值为true，表示继续向后调用，否则中断请求
	 * （不再向后调用）
	 * 注（了解）：
	 * agr2:处理器方法对象，（可以通过该对象获得处理器的方法名，参数类型，返回值
	 * 类型等）
	 */

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}
		
		
}
