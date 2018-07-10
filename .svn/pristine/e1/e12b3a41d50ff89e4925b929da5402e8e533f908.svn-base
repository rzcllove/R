package top.rzclk.modules.sys.service;

import top.rzclk.modules.sys.entity.WeixinLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 微信日志
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-20 12:33:20
 */
public interface WeixinLogService {
	
	WeixinLogEntity queryObject(Long id);
	
	List<WeixinLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WeixinLogEntity weixinLog);
	
	void update(WeixinLogEntity weixinLog);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
