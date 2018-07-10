package top.rzclk.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import top.rzclk.common.utils.StringEx;
import top.rzclk.modules.sys.dao.WeixinUserDao;
import top.rzclk.modules.sys.entity.WeixinUserEntity;
import top.rzclk.modules.sys.service.WeixinUserService;



@Service("weixinUserService")
public class WeixinUserServiceImpl implements WeixinUserService {
	@Autowired
	private WeixinUserDao weixinUserDao;
	
	@Override
	public WeixinUserEntity queryObject(Integer id){
		return weixinUserDao.queryObject(id);
	}
	
	@Override
	public List<WeixinUserEntity> queryList(Map<String, Object> map){
		return weixinUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return weixinUserDao.queryTotal(map);
	}
	
	@Override
	public void save(WeixinUserEntity weixinUser){
		weixinUserDao.save(weixinUser);
	}
	
	@Override
	public void update(WeixinUserEntity weixinUser){
		weixinUserDao.update(weixinUser);
	}
	
	@Override
	public void delete(Integer id){
		weixinUserDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		weixinUserDao.deleteBatch(ids);
	}

	@Override
	public boolean insert(WeixinUserEntity userEntity) {
		if(StringEx.isNotObjnull(userEntity)){
			if(weixinUserDao.queryOpenid(userEntity)>0){
				weixinUserDao.updateFor(userEntity);
				return true;
			}else{
				weixinUserDao.insert(userEntity);
				return true;
			}
		}else{
			return false;
		}
	}
	@Override
	public int queryOpenid(WeixinUserEntity user) {
		return weixinUserDao.queryOpenid(user);
	}
	
}
