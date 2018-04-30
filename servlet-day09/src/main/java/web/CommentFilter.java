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
	 * ���������dofilter��������������
	 * filtetchain:��������������˸ö����dofilter����
	 * �����������������;�����ж����󣨲����������ˣ�
	 * ע��
	 * servletRequest��httpservletrequest�ĸ��ӿ�
	 * ServletResponse��httpServletResponse�ĸ��ӿ�
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
			out.println("����������");
		}else{
			//����������
			chain.doFilter(req1, res1);
		}
		System.out.println("CommentFilter end");
	}
	/**
	 *ʵ����֮�󣬻�����ִ��init����
	 *��ִ�и÷���ʱ���ὫFilterConfig��Ϊ����������
	 *֮��ִ��һ��
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CommentFilter init");
		this.config=arg0;
	}
	/**
	 *  ��������֮���������������������
	 *  ע��ֻ�ᴴ��һ��
	 */
	public CommentFilter() {
		System.out.println("CommentFilter");
		
	}

	
	
}
