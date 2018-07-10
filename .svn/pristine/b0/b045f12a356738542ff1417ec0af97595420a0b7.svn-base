package top.rzclk.modules.generator.service;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017年3月19日 下午3:33:38
 */
public interface SysGeneratorService{

	public List<Map<String, Object>> queryList(Map<String, Object> map);
	public int queryTotal(Map<String, Object> map);

	public Map<String, String> queryTable(String tableName);

	public List<Map<String, String>> queryColumns(String tableName);

	public byte[] generatorCode(String[] tableNames);
}
