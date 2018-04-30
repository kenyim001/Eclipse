package cn.tedu.ems.dao;

import cn.tedu.ems.controller.User;

public interface UserDAO {
		public User FindByUsername(String username);
		
}
