package cn.tedu.ttms.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ttms.system.dao.MenuDao;
import cn.tedu.ttms.system.dao.RoleDao;
import cn.tedu.ttms.system.dao.RoleMenuDao;
import cn.tedu.ttms.system.entity.Role;
import cn.tedu.ttms.system.service.RoleService;
import cn.tedu.ttms.util.PageObject;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDao roleDao;
	
	@Resource
	private MenuDao menuDao;
	
	@Resource
	private RoleMenuDao roleMenuDao;

	@Override
	public Map<String, Object> findObjects(Role role,PageObject pageObj) {
		List<Map<String,Object>> list=roleDao.findObjects(role,pageObj);
		pageObj.setRowCount(roleDao.getRowCounts(role));	
		Map<String,Object> map=new HashMap<>();
		map.put("list", list);
		map.put("pageObj",pageObj);
		return map;
	}

	@Override
	public List<Map<String, Object>> loadMenuTree() {
		return menuDao.findTreeData();
	}

	@Override
	public void save(Role role) {
		if(role==null){
			throw new NullPointerException("添加角色，角色对象不能为空!");
		}
		//查看是否越权    被添加的角色菜单不能超过创建者所拥有的角色菜单  用  containsAll   A.containsAll(B)  A:创建者的菜单  B：添加的角色的菜单
		
		//保存角色信息
		int i = roleDao.save(role);
		System.err.println(role);
		if(i!=1){
			throw new RuntimeException("添加角色失败！");
		}
		//保存角色菜单关系
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("roleId", role.getId());
		map.put("menuIdList", role.getMenuIdList());
		int counts = roleMenuDao.save(map);
		if(counts!=role.getMenuIdList().size()){
			throw new RuntimeException("添加角色授权失败！");
		}
	}

	@Override
	public Role findRoleById(Integer roleId) {
		if(roleId==null){
			throw new NullPointerException("修改角色信息，角色id不能为空！");
		}
		Map<String, Object> map = roleDao.findObjectById(roleId);
		if(map==null || map.size()==0){
			throw new RuntimeException("修改角色信息查询失败！");
		}
		List<Integer> menuIdList = roleMenuDao.findMenuIdListByRoleId(roleId);
//		if(menuIdList==null || menuIdList.size()==0){
//			throw new RuntimeException("修改角色信息查询角色权限失败！");
//		}
		
		Role role = new Role();
		role.setName((String)map.get("name"));
		role.setNote((String)map.get("note"));
		role.setMenuIdList(menuIdList);
		return role;
	}

	@Override
	public void updateRole(Role role) {
		if(role==null){
			throw new NullPointerException("修改角色信息，角色对象不能为空！");
		}
		int i = roleDao.updateObject(role);   //更新角色名称和备注
		if(i!=1){  
			throw new RuntimeException("更新角色信息失败！");
		}
		//更新角色菜单关系   - 先删除后添加
		int counts = roleMenuDao.deletObject(role.getId());
		if(counts<1){
			throw new RuntimeException("修改更新角色信息失败！");
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("roleId", role.getId());
		map.put("menuIdList", role.getMenuIdList());
		int cous = roleMenuDao.save(map);
		if(cous!=role.getMenuIdList().size()){
			throw new RuntimeException("修改更新角色授权失败！");
		}
	}
}
