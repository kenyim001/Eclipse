package cn.tedu.ems.servicce;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ems.controller.User;
import cn.tedu.ems.dao.UserDAO;

@Service("loginSerivce")
public class LoginServiceImpl implements LoginService{
		@Resource(name="userDAO")
		private UserDAO dao;
		
		public User checkLogin(String username,String pwd){
			User user=dao.FindByUsername(username);
			if(user==null){
				/**
				 * 用户名不存在
				 * 可以抛出一个应用异常 
				 * 注：表示层在捕获应用异常之后需要明确提示用户采取正确的操作
				 * 
				 */
				throw new ApplicationException("用户名不存在") ;
			}
			if(!user.getPwd().equals(pwd)){
				throw new ApplicationException("密码错误");
			}
			//登录验证通过
			return user;
		}
		
	
}
