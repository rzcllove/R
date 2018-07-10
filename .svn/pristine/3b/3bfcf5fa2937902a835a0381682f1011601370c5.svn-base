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

import top.rzclk.modules.sys.entity.WeixinShopClassEntity;
import top.rzclk.modules.sys.service.WeixinShopClassService;
import top.rzclk.common.utils.PageUtils;
import top.rzclk.common.utils.Query;
import top.rzclk.common.utils.R;




/**
 * 微信店铺分类
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-30 14:08:59
 */
@RestController
@RequestMapping("sys/weixinshopclass")
public class WeixinShopClassController extends AbstractController {
	@Autowired
	private WeixinShopClassService weixinShopClassService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys/weixinshopclass:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WeixinShopClassEntity> weixinShopClassList = weixinShopClassService.queryList(query);
		int total = weixinShopClassService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(weixinShopClassList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys/weixinshopclass:info")
	public R info(@PathVariable("id") Integer id){
		WeixinShopClassEntity weixinShopClass = weixinShopClassService.queryObject(id);
		
		return R.ok().put("weixinShopClass", weixinShopClass);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys/weixinshopclass:save")
	public R save(@RequestBody WeixinShopClassEntity weixinShopClass){
		weixinShopClassService.save(weixinShopClass);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys/weixinshopclass:update")
	public R update(@RequestBody WeixinShopClassEntity weixinShopClass){
		weixinShopClassService.update(weixinShopClass);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys/weixinshopclass:delete")
	public R delete(@RequestBody Integer[] ids){
		weixinShopClassService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
