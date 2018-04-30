package cn.tedu.ttms.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.system.entity.Role;
import cn.tedu.ttms.system.service.RoleService;
import cn.tedu.ttms.util.JsonResult;
import cn.tedu.ttms.util.PageObject;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("listUI")
	public String listUI(){
		return "system/role_list";
	}
	
	/**
	 * 查询所有信息用于展示角色列表
	 * @return
	 */
	@RequestMapping("findObjects")
	@ResponseBody
	public JsonResult findObjects(Role role,PageObject pageObj){
		Map<String, Object> map = roleService.findObjects(role,pageObj);
		return new JsonResult(map);
	}
	
	/**
	 * 显示新增页面
	 */
	@RequestMapping("editRoleUI")
	public String editRoleUI(){
		return "system/role_edit";
	}
	
	/**
	 * 加载菜单树
	 */
	@RequestMapping("loadMenuTree")
	@ResponseBody
	public JsonResult loadMenuTree(){
		List<Map<String, Object>> list = roleService.loadMenuTree();
		return new JsonResult(list);
	}
	
	/**
	 * 保存角色信息
	 */
	@RequestMapping("save")
	@ResponseBody
	public JsonResult saveRole(Role role){
		roleService.save(role);
		return new JsonResult();
	}
	
	/**
	 * 根据id查询角色信息
	 */
	@RequestMapping("findRoleById")
	@ResponseBody
	public JsonResult findRoleById(Integer roleId){
		Role role = roleService.findRoleById(roleId);
		return new JsonResult(role);
	}
	
	/**
	 * 修改更新角色信息
	 */
	@RequestMapping("updateRole")
	@ResponseBody
	public JsonResult updateRole(Role role){
		roleService.updateRole(role);
		return new JsonResult();
	}
}
