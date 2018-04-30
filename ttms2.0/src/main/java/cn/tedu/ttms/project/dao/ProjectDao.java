package cn.tedu.ttms.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.entity.Project;

/**此接口对象为一个数据访问对象(关联一个mapper)
 * 所在层:DAL(数据访问层)
 * */
public interface ProjectDao {
	/**
	 * @param entity 代表是一个project对象
	 * @return 表示insert记录的行数
	 */
	public int insertObject(Project entity);
	/**
	 * 查询项目信息
	 */
	public List<Project>  findObjects();	
	/**
	 * 分页查询项目信息
	 */
	public List<Project>  
    findPageObjects(
    	@Param("project")Project project,
    	@Param("pageObject")PageObject pageObject);
	
	/**获得表中的记录数*/
	public int getRowCount(Project project);
	/**禁用启用记录数
	 * @return 表示更新的行数,假如返回值为-1表示更新失败
	 * */
	public int validById(
			@Param("ids")String[] ids,
			@Param("valid")Integer valid);
	
}









