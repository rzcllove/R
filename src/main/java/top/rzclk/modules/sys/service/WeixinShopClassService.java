package top.rzclk.modules.sys.service;

import top.rzclk.modules.sys.entity.WeixinShopClassEntity;

import java.util.List;
import java.util.Map;

/**
 * 微信店铺分类
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-30 14:08:59
 */
public interface WeixinShopClassService {
	
	WeixinShopClassEntity queryObject(Integer id);
	
	List<WeixinShopClassEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WeixinShopClassEntity weixinShopClass);
	
	void update(WeixinShopClassEntity weixinShopClass);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
