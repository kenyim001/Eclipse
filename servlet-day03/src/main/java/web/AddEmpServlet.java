package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class AddEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//设置解码所使用的字符集，注意，该方法应该放到所有的getParameter方法前面
		//该方法指针对post请求有效
		request.setCharacterEncoding("utf-8");
		
		//读取员工的信息
		String name=request.getParameter("name");
		String salary=request.getParameter("salary");
		String age=request.getParameter("age");
		
		System.out.println(name+","+salary+","+age);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//将员工信息插入到数据库
		EmployeeDAO dao=new EmployeeDAO();
		Employee emp=new Employee();
		emp.setName(name);
		emp.setSalary(Double.parseDouble(salary));
		emp.setAge(Integer.parseInt(age));
		try {
			dao.save(emp);
//			out.println("添加成功");
			//重定向到员工列表
			response.sendRedirect("list");//重定向地址是任意的，地址会改变
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
		//不调用close也可以，因为容器在执行完service方法之后，会自动关闭out。
		out.close();
	}
}
