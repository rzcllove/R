package top.rzclk.modules.generator.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import top.rzclk.modules.sys.dao.BaseDao;

/**
 * 代码生成器
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017年3月19日 下午3:32:04
 */
@Mapper
public interface SysGeneratorDao{
	
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	Map<String, String> queryTable(String tableName);
	
	List<Map<String, String>> queryColumns(String tableName);
}
