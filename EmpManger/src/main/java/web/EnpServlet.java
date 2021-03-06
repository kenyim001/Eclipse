package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

/*
 * 开发规范：
 * 查询员工：/find.emp
 * 增加员工：/add.emp
 * 
 * */

public class EnpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//判断访问路径并处理请求
		String path=req.getServletPath();
		if("/find.emp".equals(path)){
			findEmp(req,res);
		}else if("/add.emp".equals(path)){
			addEmp(req,res);
		}else{
			throw new RuntimeException("查无此页");
		}
	}



	protected void findEmp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.接收参数
		//2.处理业务
		EmpDao dao=new EmpDao();
		List<Emp> list=dao.findAll();
		//3.发送响应
		res.setContentType("text/html;charset=utf-8");
		PrintWriter w=res.getWriter();
		//当前：/EmpManger/findEmp
		//目标：/EmpManger/add_emp.html
		w.println("<a href='add_emp.html'>增加</a>");
		w.println("<table border='1' cellspacing='0' width='30%'>");
		
		w.println("<tr>");
		w.println("       <td>编号</td>");
		w.println("       <td>姓名</td>");
		w.println("       <td>职位</td>");
		w.println("       <td>薪资</td>");
		w.println("</tr>");
		if(list !=null){
			for(Emp e:list){
				w.println("<tr>");
				w.println("	<td>"+e.getEmpno()+"</td>");
				w.println("	<td>"+e.getEname()+"</td>");
				w.println("	<td>"+e.getJob()+"</td>");
				w.println("	<td>"+e.getSal()+"</td>");
				w.println("</tr>");
			}
		}
		w.println("</table>");
		w.close();
	}



	
	protected void addEmp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		//1.接收参数
		res.setCharacterEncoding("utf-8");
		String ename=req.getParameter("ename");
		String job=req.getParameter("job");
		String sal=req.getParameter("sal");
		
		//2.保存员工数据
		Emp e=new Emp();
		e.setEname(ename);
		e.setJob(job);
		e.setSal(Double.valueOf(sal));
		new EmpDao().save(e);
		
		//3.发送响应
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out=res.getWriter();
//		out.println("<b>保存成功</b>");
//		out.close();
		//重定向到查询页面，即建议浏览器自已访问查询页面
			res.sendRedirect("find.emp");

	}

	
	
	
	
}
