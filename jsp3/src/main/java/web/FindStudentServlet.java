package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Student;

public class FindStudentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				
	//模拟查询学生
		Student s=new Student();
		s.setName("zhangsan");
		s.setAge(25);
		s.setSex("M");
		s.setInterests(new String[]{"篮球","足球","排球"});
		Course c=new Course();
		c.setCourseId(1);
		c.setName("Java");
		c.setDays(85);
		s.setCourse(c);
		//将数据绑定到requesth 上
		req.setAttribute("stu",s);
		//将请求转发给student.jsp
		req.getRequestDispatcher("student.jsp").forward(req, res);
		
		
	}

}
