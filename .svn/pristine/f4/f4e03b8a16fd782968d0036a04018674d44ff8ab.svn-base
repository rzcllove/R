package top.rzclk.modules.job.dao;

import org.apache.ibatis.annotations.Mapper;

import top.rzclk.modules.job.entity.ScheduleJobEntity;
import top.rzclk.modules.sys.dao.BaseDao;

import java.util.Map;

/**
 * 定时任务
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2016年12月1日 下午10:29:57
 */
@Mapper
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
