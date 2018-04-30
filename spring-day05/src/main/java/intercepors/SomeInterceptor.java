package intercepors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements
	HandlerInterceptor{
	/**
	 * ���ִ�еķ���
	 * ע(�˽�)��
	 * arg3�Ǵ������������׳����쳣
	 * 
	 */
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
		
	}

	/**
	 * ������(controller)�ķ����Ѿ�ִ�������׼������������modelAndView�����ظ�DispatcherServlet
	 *  ֮ǰִ��postHandle����
	 *  ע�������ڸ÷������棬�޸�ModelAndView
	 */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("psotHandle()");
		
	}
	
	/**
	 * DispatcherServlet���յ�����֮����ȵ�����������preHandle����
	 * ����÷����ķ���ֵΪtrue����ʾ���������ã������ж�����
	 * �����������ã�
	 * ע���˽⣩��
	 * agr2:�������������󣬣�����ͨ���ö����ô������ķ��������������ͣ�����ֵ
	 * ���͵ȣ�
	 */

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}
		
		
}
