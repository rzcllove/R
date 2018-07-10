package top.rzclk.modules.sys.service;

import top.rzclk.modules.sys.entity.WeixinUserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 微信用户
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-20 15:27:13
 */
public interface WeixinUserService {
	
	WeixinUserEntity queryObject(Integer id);
	
	List<WeixinUserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WeixinUserEntity weixinUser);
	
	void update(WeixinUserEntity weixinUser);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	boolean insert(WeixinUserEntity user);
	
	int queryOpenid(WeixinUserEntity user);
}
