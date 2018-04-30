package cn.tedu.ttms.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.entity.Project;

public interface ProjectDao {
	
	public List<Project> findObjects();
	
	public int getRowCount(@Param("project")Project project);
	
	public List<Project> findPageObjects(@Param("project") Project project,@Param("pageObject")PageObject pageObject);
}
