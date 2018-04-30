package cn.tedu.ttms.project.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.service.ProjectService;
/**
 * 产品项目管理控制器对象
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
	@Resource
	private ProjectService projectService;

	@RequestMapping("/listUI")
	public String listUI(){
		return "project/project_list";
	}

	@RequestMapping("/findPageObjects")
	@ResponseBody
	public Map<String,Object> 
     findPageObjects(Project project,PageObject pageObject){//pageCurrent
		return projectService.
			findPageObjects(project,pageObject);
	}
	@RequestMapping("/doValidById")
	@ResponseBody
	public String doValidById(String checkedIds,Integer valid){
		System.out.println("checkedIds="+checkedIds);
		System.out.println("valid="+valid);
		projectService.validById(checkedIds, valid);
		return "{}";//后续要进行封装
	}
	

}




