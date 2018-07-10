package top.rzclk.modules.sys.service;

import top.rzclk.common.utils.R;
import top.rzclk.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService {

	SysUserTokenEntity queryByUserId(Long userId);

	SysUserTokenEntity queryByToken(String token);
	
	void save(SysUserTokenEntity token);
	
	void update(SysUserTokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

}
