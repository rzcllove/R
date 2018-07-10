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

import top.rzclk.modules.sys.entity.WeixinUserEntity;
import top.rzclk.modules.sys.service.WeixinUserService;
import top.rzclk.common.utils.PageUtils;
import top.rzclk.common.utils.Query;
import top.rzclk.common.utils.R;




/**
 * 微信用户
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-20 15:27:13
 */
@RestController
@RequestMapping("sys/weixinuser")
public class WeixinUserController extends AbstractController {
	@Autowired
	private WeixinUserService weixinUserService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys/weixinuser:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WeixinUserEntity> weixinUserList = weixinUserService.queryList(query);
		int total = weixinUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(weixinUserList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys/weixinuser:info")
	public R info(@PathVariable("id") Integer id){
		WeixinUserEntity weixinUser = weixinUserService.queryObject(id);
		
		return R.ok().put("weixinUser", weixinUser);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys/weixinuser:save")
	public R save(@RequestBody WeixinUserEntity weixinUser){
		weixinUserService.save(weixinUser);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys/weixinuser:update")
	public R update(@RequestBody WeixinUserEntity weixinUser){
		weixinUserService.update(weixinUser);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys/weixinuser:delete")
	public R delete(@RequestBody Integer[] ids){
		weixinUserService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
