package cn.tedu.ems.servicce;

import cn.tedu.ems.controller.User;

public interface LoginService {

	public User checkLogin(String username,String pwd); 

}
