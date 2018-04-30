package cn.tedu.hotel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.hotel.service.ApplicationException;
import cn.tedu.hotel.service.UserService;
import cn.tedu.hotel.dao.HotelDAO;
import cn.tedu.hotel.entity.User;

@Service("service")
public class UserServiceImpl implements UserService{
	@Resource
	private HotelDAO dao;
	//修改客户休息
	


	public User findByTel(String telephone) {
		
		return dao.findByTel(telephone);
	}
	//修改信息
	public void modifyUser(User user) {
		dao.modifyUser(user);
			
	}
	public User checkLogin(String Tel, String password) {
		User user = dao.findByTel(Tel);
		if(user==null){
		
			throw new ApplicationException("该手机未注册");
		}
		if(!user.getPassword().equals(password)){
			throw new ApplicationException("密码错误");
		}
		
		return user;
	}


}
