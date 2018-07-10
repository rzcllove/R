package top.rzclk.modules.api.service;


import java.util.Map;

import top.rzclk.modules.api.entity.TokenEntity;

/**
 * 用户Token
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-03-23 15:22:07
 */
public interface TokenService {

	TokenEntity queryByUserId(Long userId);

	TokenEntity queryByToken(String token);
	
	void save(TokenEntity token);
	
	void update(TokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 * @return        返回token相关信息
	 */
	Map<String, Object> createToken(long userId);

}
