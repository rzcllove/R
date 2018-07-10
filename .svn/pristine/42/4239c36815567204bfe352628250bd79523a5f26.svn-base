package top.rzclk.modules.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.rzclk.modules.sys.entity.WeixinLogEntity;
import top.rzclk.modules.sys.service.WeixinLogService;
import top.rzclk.common.utils.PageUtils;
import top.rzclk.common.utils.Query;
import top.rzclk.common.utils.R;




/**
 * 微信日志
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-20 12:33:20
 */
@RestController
@RequestMapping("sys/weixinlog")
public class WeixinLogController extends AbstractController {
	@Autowired
	private WeixinLogService weixinLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys/weixinlog:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WeixinLogEntity> weixinLogList = weixinLogService.queryList(query);
		int total = weixinLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(weixinLogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys/weixinlog:info")
	public R info(@PathVariable("id") Long id){
		WeixinLogEntity weixinLog = weixinLogService.queryObject(id);
		
		return R.ok().put("weixinLog", weixinLog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys/weixinlog:save")
	public R save(@RequestBody WeixinLogEntity weixinLog){
		weixinLogService.save(weixinLog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys/weixinlog:update")
	public R update(@RequestBody WeixinLogEntity weixinLog){
		weixinLogService.update(weixinLog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys/weixinlog:delete")
	public R delete(@RequestBody Long[] ids){
		weixinLogService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
