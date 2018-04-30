package cn.tedu.ttms.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.dao.ProjectDao;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	@Resource
	private ProjectDao projectDao;
	@Override
	public List<Project> findObjects() {
		
		return projectDao.findObjects();
	}
	@Override
	public Map<String, Object> findPageObjects(Project project,PageObject pageObject) {
		List<Project> list=projectDao.findPageObjects(project,pageObject);
		int rowCount=projectDao.getRowCount(project);
		pageObject.setRowCount(rowCount);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		
		return map;
	}
	

}
