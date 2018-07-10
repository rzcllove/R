package top.rzclk.modules.api.dao;

import org.apache.ibatis.annotations.Mapper;

import top.rzclk.modules.api.entity.UserEntity;
import top.rzclk.modules.sys.dao.BaseDao;

/**
 * 用户
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-03-23 15:22:06
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

	UserEntity queryByMobile(String mobile);
}
