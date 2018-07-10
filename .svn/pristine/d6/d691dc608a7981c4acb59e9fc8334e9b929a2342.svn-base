package top.rzclk.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import top.rzclk.modules.sys.dao.WeixinShopClassDao;
import top.rzclk.modules.sys.entity.WeixinShopClassEntity;
import top.rzclk.modules.sys.service.WeixinShopClassService;



@Service("weixinShopClassService")
public class WeixinShopClassServiceImpl implements WeixinShopClassService {
	@Autowired
	private WeixinShopClassDao weixinShopClassDao;
	
	@Override
	public WeixinShopClassEntity queryObject(Integer id){
		return weixinShopClassDao.queryObject(id);
	}
	
	@Override
	public List<WeixinShopClassEntity> queryList(Map<String, Object> map){
		return weixinShopClassDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return weixinShopClassDao.queryTotal(map);
	}
	
	@Override
	public void save(WeixinShopClassEntity weixinShopClass){
		weixinShopClass.setCreateTime(new Date());
		weixinShopClassDao.save(weixinShopClass);
	}
	
	@Override
	public void update(WeixinShopClassEntity weixinShopClass){
		weixinShopClassDao.update(weixinShopClass);
	}
	
	@Override
	public void delete(Integer id){
		weixinShopClassDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		weixinShopClassDao.deleteBatch(ids);
	}
	
}
