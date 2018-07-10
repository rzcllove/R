package top.rzclk.modules.sys.dao;

import top.rzclk.modules.sys.entity.WeixinTokenEntity;
import top.rzclk.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信Token表
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-20 14:55:21
 */
@Mapper
public interface WeixinTokenDao extends BaseDao<WeixinTokenEntity> {
	
}
