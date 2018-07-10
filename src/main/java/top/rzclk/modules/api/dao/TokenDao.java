package top.rzclk.modules.api.dao;

import org.apache.ibatis.annotations.Mapper;

import top.rzclk.modules.api.entity.TokenEntity;
import top.rzclk.modules.sys.dao.BaseDao;

/**
 * 用户Token
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @Time 2017年8月9日 下午5:33:44 
 *
 */
@Mapper
public interface TokenDao extends BaseDao<TokenEntity> {
    
    TokenEntity queryByUserId(Long userId);

    TokenEntity queryByToken(String token);
	
}
