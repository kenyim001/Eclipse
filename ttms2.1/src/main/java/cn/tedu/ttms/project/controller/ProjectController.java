package cn.tedu.ttms.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Resource
	private ProjectService projectService;
	
	
	@RequestMapping("/listUI")
	public String listUI(){
		return "project/project_list";
	}
	
	@RequestMapping("/findObjects")
	@ResponseBody
	public Map<String,Object> findObjects(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", 1);
		map.put("code", "TT-20170711-CHN-BJ-001");
		map.put("name", "环球游");
		return map;
		
	}
	
	@RequestMapping("/projectList")
	@ResponseBody
	public List<Project> projectList(){
		return projectService.findObjects();
	}
	
	@RequestMapping("/findPageObjects")
	@ResponseBody
	public Map<String,Object> findPageObject(Project project,PageObject pageObject){
		return projectService.findPageObjects(project,pageObject);
	}
	
	
}
