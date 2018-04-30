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
	/**
	 * 此方法用于返回项目管理的列表页面
	 * http://localhost:8080/ttms2.0/project/listUI.do
	 * @return
	 */
	@RequestMapping("/listUI")
	public String listUI(){
		//查看spring-mvc.xml (查看视图解析器)
		return "project/project_list";
	}//? return 语句返回的字符串对应一个jsp文件(
	//在哪,名字是什么)

	
	//[{"id":1,"code":"TT-20170711-CHN-BJ-001","name":"环球游"},....]
	@RequestMapping("/projectList")
	@ResponseBody
	public List<Project> projectList(){
		return projectService.findObjects();
	}
	
	@RequestMapping("/findPageObjects")
	@ResponseBody
	public Map<String,Object> 
     findPageObjects(Project project,PageObject pageObject){//pageCurrent
		return projectService.
			findPageObjects(project,pageObject);
	}
	

}




