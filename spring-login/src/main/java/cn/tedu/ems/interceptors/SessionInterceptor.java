package cn.tedu.ems.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ������
 * ����session��֤
 * @author kenyim
 *
 */

public class SessionInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		//�Ȼ��session����
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("user");
		if(obj==null){
			//�����session�������Ҳ�����Ӧ����˵��û�е�½���ض��򵽵�¼ҳ��
			res.sendRedirect("toLogin.do");
			return false;
		}
		//����Ѿ���¼�������������
		return true;
	}
		
}
