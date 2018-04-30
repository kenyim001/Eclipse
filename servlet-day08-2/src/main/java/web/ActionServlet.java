package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

public class ActionServlet extends HttpServlet {
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//�������� 
		request.setCharacterEncoding("utf-8");
		//���������Դ·��
		String uri=request.getRequestURI();
		String action=uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		if("/login".equals(action)){
			/**
			 * �ȱȽ���֤���Ƿ���ȷ
			 * �����֤�벻��ȷ�����ٱȽ��û���������
			 */
			//�û��ύ��������֤��
			String number1=request.getParameter("number").toUpperCase();
			//session���������Ȱ󶩵���֤��
			HttpSession session=request.getSession();
			String number2=(String) session.getAttribute("number");
			if(!number1.equals(number2)){
				request.setAttribute("number_error", "��֤�����");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			//��ȡ�û���������
			String username=request.getParameter("username");
			String pwd=request.getParameter("pwd");
			System.out.println("username:"+username+"pwd:"+pwd);
			//��ѯ���ݿ�
			UserDao dao=new UserDao();
			try {
				User user=dao.findByUsername(username);
				if(user !=null&&
						user.getPwd().equals(pwd)){
					//��½�ɹ�
					session.setAttribute("user", user);
					response.sendRedirect("index.jsp");
					
				}else{
					//��½ʧ��
					request.setAttribute("login_failed", "�û������������");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		
	}

}
