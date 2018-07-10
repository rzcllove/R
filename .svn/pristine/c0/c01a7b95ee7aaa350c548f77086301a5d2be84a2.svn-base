package top.rzclk.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import top.rzclk.modules.sys.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2016年9月18日 上午9:33:01
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取菜单
	 */
	List<SysMenuEntity> queryListMenu(Map<String, Object> map);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();
	
	/**
	 * 查询用户的权限列表
	 */
	List<SysMenuEntity> queryUserList(Long userId);
	
	/**
	 * 查询部门开关
	 */
	Long getDetpOpen();
	
	/**
	 * 禁用子级菜单
	 */
	Long updateBatch(@Param("state")Long state,@Param("parentId")Long parentId);
}
