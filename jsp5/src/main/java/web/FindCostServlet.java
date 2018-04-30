package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindCostServlet  extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//本次请求中,浏览器会自动传入事先保存的jsessionid然后服务器根据
		//此id打到旧的session
		HttpSession session=req.getSession();
		String user=(String)session.getAttribute("user");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter w=res.getWriter();
		w.print(user);
		w.close();
	}

}
