package top.rzclk.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import top.rzclk.modules.sys.dao.WeixinLogDao;
import top.rzclk.modules.sys.entity.WeixinLogEntity;
import top.rzclk.modules.sys.service.WeixinLogService;



@Service("weixinLogService")
public class WeixinLogServiceImpl implements WeixinLogService {
	@Autowired
	private WeixinLogDao weixinLogDao;
	
	@Override
	public WeixinLogEntity queryObject(Long id){
		return weixinLogDao.queryObject(id);
	}
	
	@Override
	public List<WeixinLogEntity> queryList(Map<String, Object> map){
		return weixinLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return weixinLogDao.queryTotal(map);
	}
	
	@Override
	public void save(WeixinLogEntity weixinLog){
		weixinLogDao.save(weixinLog);
	}
	
	@Override
	public void update(WeixinLogEntity weixinLog){
		weixinLogDao.update(weixinLog);
	}
	
	@Override
	public void delete(Long id){
		weixinLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		weixinLogDao.deleteBatch(ids);
	}
	
}
