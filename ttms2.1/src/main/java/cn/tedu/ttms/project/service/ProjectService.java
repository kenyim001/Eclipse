package cn.tedu.ttms.project.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.entity.Project;

public interface ProjectService {
	
		public List<Project> findObjects();
		
		public Map<String,Object> findPageObjects(Project project, PageObject pageObject);
}
