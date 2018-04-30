package cn.tedu.aop;

import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	public int saveObject(Object Obj) {
		System.out.println("saveObject");
		return 1;
	}

	public int updateObject(Object obj) {
		System.out.println("updateObject");
		return 1;
	}
	
}
