package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;
public class Actionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("action:"+action);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if("/quoto".equals(action)){
			//模拟生成几个股票的信息
			
			List<Stock> stocks=new ArrayList<Stock>();
			Random r=new Random();
			for (int i = 0; i < 8; i++) {
				Stock s=new Stock();
				s.setCode(""+r.nextInt(10000));
				s.setName(""+r.nextInt(10000));
				s.setPrice(r.nextInt(10000));
				stocks.add(s);
			}
			ObjectMapper om=new ObjectMapper();
			String jsonStr=om.writeValueAsString(stocks);
			System.out.println(jsonStr);
			
			out.println(jsonStr);
		}else if("/shownumber".equals(action)){
			int a=(int)(Math.random()*100);
			out.print(a);
		}else if("/saveInfo".equals(action)){
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			System.out.println(name+":"+phone+":"+address);
			System.out.println("你的资料已保存");
		}
	}

}
