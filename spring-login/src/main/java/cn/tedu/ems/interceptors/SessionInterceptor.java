package cn.tedu.ems.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 * 用于session验证
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
		//先获得session对象
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("user");
		if(obj==null){
			//如果从session对象上找不到对应的数说明没有登陆，重定向到登录页面
			res.sendRedirect("toLogin.do");
			return false;
		}
		//如果已经登录，则继续向后调用
		return true;
	}
		
}
