package cn.tedu.ttms.system.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.system.entity.Role;
import cn.tedu.ttms.util.PageObject;

public interface RoleService {

	Map<String, Object> findObjects(Role role, PageObject pageObj);

	List<Map<String, Object>> loadMenuTree();

	void save(Role role);

	Role findRoleById(Integer roleId);

	void updateRole(Role role);

}
