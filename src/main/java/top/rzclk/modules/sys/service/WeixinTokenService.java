package top.rzclk.modules.sys.service;

import top.rzclk.modules.sys.entity.WeixinTokenEntity;

import java.util.List;
import java.util.Map;

/**
 * 微信Token表
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-20 14:55:21
 */
public interface WeixinTokenService {
	
	WeixinTokenEntity queryObject(Integer id);
	
	List<WeixinTokenEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WeixinTokenEntity weixinToken);
	
	void update(WeixinTokenEntity weixinToken);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
