package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilyter implements Filter {

	public void destroy() {
		System.out.println("����LogFilter");
	}

	//������ҵ���ڴ˴�ʵ��
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("��ǰ�����־");
		chain.doFilter(request,response);
		System.out.println("�ں������־");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��ʼ��LogFilter");
	}

}
