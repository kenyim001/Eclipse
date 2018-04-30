package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import dao.EmployeeDAO;
import dao.UserDao;
import entity.Employee;
import entity.User;

public class EmpServlet extends  HttpServlet{

	@Override
		protected void service(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			
			String uri=req.getRequestURI();
			 String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
			 if("/add".equals(action)){
				 AddEmp(req,res);
			 }else if("/del".equals(action)){
				 DeleteEmp(req,res);
			}else if("/list".equals(action)){
				FindAllEmp(req,res);
			}else if("/load".equals(action)){
				LoadEmp(req,res);
			}else if("/modify".equals(action)){
				ModifyEmp(req,res);
			}else if("/login".equals(action)){
				LoginEmp(req,res);
			}else if("/logout".equals(action)){
				LogoutEmp(req,res);
			}else if("/checkcode".equals(action)){
				Checkcode(req,res);
			}
	 }
		
		public void AddEmp(HttpServletRequest req,
					HttpServletResponse res) 
							throws ServletException,IOException{
	/*public class AddEmpServlet extends HttpServlet{
		public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		设置解码所使用的字符集，注意，该方法应该放到所有的getParameter方法前面
		该方法指针对post请求有效
		request.setCharacterEncoding("utf-8");
		*/		
		//读取员工的信息
//		System.out.println("1111");
		String name=req.getParameter("name");
		String salary=req.getParameter("salary");
		String age=req.getParameter("age");
		
//		System.out.println(name+","+salary+","+age);
		
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out=res.getWriter();
		
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
			res.sendRedirect("list.do");//重定向地址是任意的，地址会改变
			
		} catch (Exception e) {
			e.printStackTrace();
//			out.println("系统繁忙，稍后重试");
			req.getRequestDispatcher("error.jsp").forward(req, res);
		}
		//不调用close也可以，因为容器在执行完service方法之后，会自动关闭out。
//		out.close();
	}
  
		public void DeleteEmp(HttpServletRequest req,
			HttpServletResponse res
			)throws ServletException,IOException{
		String id=req.getParameter("id");
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out=res.getWriter();
		
		EmployeeDAO dao=new EmployeeDAO();
		try {
			dao.delete(Integer.parseInt(id));
			//重定向到员工列表
			res.sendRedirect("list.do");
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("error.jsp").forward(req, res);
		}
//		out.close();
	}
	
		public void FindAllEmp(HttpServletRequest req,
				HttpServletResponse res)throws ServletException,IOException{
//			String ip=req.getRemoteHost();
//			System.out.println("ip:"+ip);
//			
//			res.setContentType("text/html;charset=utf-8");
//			PrintWriter out=res.getWriter();
			
			EmployeeDAO dao=new EmployeeDAO();
			try {
				List<Employee> list=dao.findAll();
			/*	out.println("<table border='1' width='60%' cellpadding='0' cellspacing='0'>");
				out.println("<tr><td>ID</td><td>姓名</td><td>年龄</td><td>薪水</td><td>操作</td></tr>");
				for(Employee emp:list){
					int id=emp.getId();
					String name=emp.getName();
					int age=emp.getAge();
					double salary=emp.getSalary();
					out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+salary+"</td><td><a href='del?id="+id+"'>删除</a>&nbsp;<a href='load?id="+id+"'>修改</a></td></tr>");
				}
				out.println("</table>");
				out.println("<a href='addEmp.html'>添加员工</a>");*/
				//依据查询到的员工信息，输出表格
				 //因为servlet不方便输出，所以
				//转发给listemp3.jsp来生成表格、
				
				//setp1.将数据绑定request对象上
				req.setAttribute("employees", list);
				//step2.获得转发器
				RequestDispatcher rd=req.getRequestDispatcher("empList.jsp");
				//step3转发
				rd.forward(req,res);
			} catch (Exception e) {
				e.printStackTrace();
				req.getRequestDispatcher("error.jsp").forward(req, res); //转发
			}
		}

		public void  LoadEmp(HttpServletRequest req,
				HttpServletResponse res)throws ServletException,IOException{
			String id=req.getParameter("id");
			
//			res.setContentType("text/html;charset=utf-8");
//			PrintWriter out=res.getWriter();
			
			//依据id查询员工的信息
			EmployeeDAO dao=new EmployeeDAO();
			try {
				Employee emp=dao.findById(Integer.parseInt(id));
				/*		String name=emp.getName();
				int age=emp.getAge();
				double salary=emp.getSalary();
				//依据查询到的员工信息，生成修改页面
				out.println("<form action='modify' method='post'>");
				out.println("姓名： <input name='name' value='"+name+"'/><br/>");
				out.println("年龄： <input name='age' value='"+age+"'/><br/>");
				out.println("薪水： <input name='salary' value='"+salary+"'/><br/>");
				out.println("<input type='hidden' name='id' value='"+id+"'/>");
				out.println("<input type='submit' value='保存'/>");
				out.println("</form>");*/
				req.setAttribute("Employee", emp);
				RequestDispatcher rd=req.getRequestDispatcher("updateEmp.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
				req.getRequestDispatcher("error.jsp").forward(req, res);
			}
//			out.close();
		}

		public void ModifyEmp(HttpServletRequest req,
				HttpServletResponse res)throws ServletException,IOException{
//			PrintWriter out=res.getWriter();
			
			//读取员工信息
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			int age=Integer.parseInt(req.getParameter("age"));
			double salary=Double.parseDouble(req.getParameter("salary"));
			Employee emp=new Employee(id, name, salary, age);
			
			//修改员工信息
			EmployeeDAO dao=new EmployeeDAO();
			try {
				dao.modify(emp);
				res.sendRedirect("list.do");//重定向list页面
			} catch (Exception e) {
				e.printStackTrace();
				req.getRequestDispatcher("error.jsp").forward(req, res);
			}
//			out.close();
		}
		
		public void LoginEmp(HttpServletRequest req,
				HttpServletResponse res)throws ServletException,IOException{
//			String uri=req.getRequestURI();
//			String action=uri.substring(
//					uri.lastIndexOf("/"),
//					uri.lastIndexOf("."));
//			if("/login".equals(action)){
			/**
			 * 先比较验证码是否正确
			 * 如果验证码不正确，不再比较用户名和密码
			 */
			//用户提交过来的验证码
			String number1=req.getParameter("number").toUpperCase();
			//session对象上事先绑订的验证码
			HttpSession session=req.getSession();
			String number2=(String) session.getAttribute("number");
			if(!number1.equals(number2)){
				req.setAttribute("number_error", "验证码错误");
				req.getRequestDispatcher("login.jsp").forward(req, res);
				return;
			}
			
			
				String username=req.getParameter("username");
				String pwd=req.getParameter("pwd");
				UserDao dao=new UserDao();
				
				System.out.println(pwd);
				try {
					User user=dao.findByUsername(username);
					if(user !=null&&
							user.getPwd().equals(pwd)){
					
						//登陆成功
						session.setAttribute("user", user);
						res.sendRedirect("list.do");
					}else{
						//登陆失败
						req.setAttribute("login_failed", "用户名或密码错误");
						req.getRequestDispatcher("login.jsp").forward(req, res);
					}
				} catch (Exception e) {
					e.printStackTrace();
					req.getRequestDispatcher("error.jsp").forward(req, res);
				}
			}
	
		public void LogoutEmp(HttpServletRequest req,
				HttpServletResponse res)throws ServletException,IOException{
			HttpSession session=req.getSession(false);  
			if(session==null){  
				res.sendRedirect("login.jsp");
				return;
			}	
				
				session.invalidate();
				 res.sendRedirect("login.jsp");  
		}

		public void Checkcode(HttpServletRequest req,
				HttpServletResponse res)throws ServletException,IOException{
			
	    		System.out.println("checkcode...");
	    		/**
	    		 * step1生成图片
	    		 */
	    		//创建一个画布
	    			BufferedImage img=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
	    		//获得画笔
	    			Graphics g=img.getGraphics();
	    			//给笔设置颜色
	    			g.setColor(new Color(255, 255, 255));
	    			//设置画布背景颜色范围
	    			g.fillRect(0, 0, 80, 30);
	    			//给笔设置颜色
	    			Random  r=new Random();
	    			g.setColor(new Color(
	    					r.nextInt(255), 
	    					r.nextInt(255), 
	    					r.nextInt(255)));
	    			//设置字体
	    			g.setFont(new Font(null,Font.BOLD,24));
	    			//生成一个随机数
	    			String number=getNumber(5);
	    			//将图片上绘制随机数
	    			g.drawString(number, 2, 25);//左下角坐标
	    			
	    			//绑定
	    			HttpSession session=req.getSession();
	    			session.setAttribute("number",number);
	    			
	    			//设置线
	    			for (int i = 0; i < 8; i++) {
	    				g.setColor(new Color(
	        					r.nextInt(255), 
	        					r.nextInt(255), 
	        					r.nextInt(255)));
						g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), 30);
					}
	    			
	    		/**
	    		 * step2 压缩图片并输出jpeg
	    		 */
	    			//告诉浏览器，服务器返回的是一张图片
	    			res.setContentType("image/jpeg");
	    			//要获得字节输出流
	    			OutputStream output=res.getOutputStream();
	    			//将原始图片按照指定的格式 （jpeg）进行压缩，然后输出
	    			javax.imageio.ImageIO.write(img, "jpeg", output);
	    			output.close();
	    			
	    }
	    	/**
	    	 * 
	    	 * 长度为size个字符，随机从A-z,0-9中选取
	    	 * 的字符串
	    	 */
	    		public String getNumber(int size){
	    			String chars="ABCDEFGHIJKLNMOPQRSTUVWYZ"
	    					+ "0123456789";
	    			String number="";
	    			Random r=new Random();
	    			for (int i = 0; i < size; i++) {
						number+=chars.charAt(r.nextInt(chars.length()));
					}
	    			return number;
	    		}
			
		}


