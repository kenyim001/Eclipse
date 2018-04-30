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
				
	//ģ���ѯѧ��
		Student s=new Student();
		s.setName("zhangsan");
		s.setAge(25);
		s.setSex("M");
		s.setInterests(new String[]{"����","����","����"});
		Course c=new Course();
		c.setCourseId(1);
		c.setName("Java");
		c.setDays(85);
		s.setCourse(c);
		//�����ݰ󶨵�requesth ��
		req.setAttribute("stu",s);
		//������ת����student.jsp
		req.getRequestDispatcher("student.jsp").forward(req, res);
		
		
	}

}
