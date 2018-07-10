package top.rzclk.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import top.rzclk.modules.sys.dao.WeixinTokenDao;
import top.rzclk.modules.sys.entity.WeixinTokenEntity;
import top.rzclk.modules.sys.service.WeixinTokenService;



@Service("weixinTokenService")
public class WeixinTokenServiceImpl implements WeixinTokenService {
	@Autowired
	private WeixinTokenDao weixinTokenDao;
	
	@Override
	public WeixinTokenEntity queryObject(Integer id){
		return weixinTokenDao.queryObject(id);
	}
	
	@Override
	public List<WeixinTokenEntity> queryList(Map<String, Object> map){
		return weixinTokenDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return weixinTokenDao.queryTotal(map);
	}
	
	@Override
	public void save(WeixinTokenEntity weixinToken){
		weixinTokenDao.save(weixinToken);
	}
	
	@Override
	public void update(WeixinTokenEntity weixinToken){
		weixinTokenDao.update(weixinToken);
	}
	
	@Override
	public void delete(Integer id){
		weixinTokenDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		weixinTokenDao.deleteBatch(ids);
	}
	
}
