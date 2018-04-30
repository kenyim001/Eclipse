package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter implements Filter{
	private FilterConfig config;
	
	
	public void destroy() {
		
	}

	/**
	 * 容器会调用dofilter方法来处理请求
	 * filtetchain:过滤链如果调用了该对象的dofilter方法
	 * 则容器会继续向后调用;否则中断请求（不再向后调用了）
	 * 注：
	 * servletRequest是httpservletrequest的父接口
	 * ServletResponse是httpServletResponse的父接口
	 * 
	 */
	
	public void doFilter(ServletRequest req1, ServletResponse res1, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("CommentFilter doFilter");
		HttpServletRequest req=(HttpServletRequest) req1;
		HttpServletResponse res=(HttpServletResponse) res1;
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		String content=req.getParameter("content");
		String illegalStr=config.getInitParameter("illegalStr");
		if(content.indexOf(illegalStr)!=-1){
			out.println("包含敏感字");
		}else{
			//继续向后调用
			chain.doFilter(req1, res1);
		}
		System.out.println("CommentFilter end");
	}
	/**
	 *实例化之后，会立即执行init方法
	 *在执行该方法时，会将FilterConfig作为参数传进行
	 *之后执行一次
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CommentFilter init");
		this.config=arg0;
	}
	/**
	 *  容器启动之后会立即创建过滤器对象
	 *  注：只会创建一个
	 */
	public CommentFilter() {
		System.out.println("CommentFilter");
		
	}

	
	
}
