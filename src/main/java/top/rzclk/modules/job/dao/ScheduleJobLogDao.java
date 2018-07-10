package top.rzclk.modules.job.dao;

import org.apache.ibatis.annotations.Mapper;

import top.rzclk.modules.job.entity.ScheduleJobLogEntity;
import top.rzclk.modules.sys.dao.BaseDao;

/**
 * 定时任务日志
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2016年12月1日 下午10:30:02
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
