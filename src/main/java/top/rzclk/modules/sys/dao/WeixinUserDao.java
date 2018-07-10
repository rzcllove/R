package top.rzclk.modules.sys.dao;

import top.rzclk.modules.sys.entity.WeixinUserEntity;
import top.rzclk.modules.sys.dao.BaseDao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.google.gson.JsonObject;

/**
 * 微信用户
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-20 15:27:13
 */
@Mapper
public interface WeixinUserDao extends BaseDao<WeixinUserEntity> {
	boolean insert(WeixinUserEntity user);
	boolean updateFor(WeixinUserEntity user);
	int queryOpenid(WeixinUserEntity user);
}
