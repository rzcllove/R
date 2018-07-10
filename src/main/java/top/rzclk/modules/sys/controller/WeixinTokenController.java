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

import top.rzclk.modules.sys.entity.WeixinTokenEntity;
import top.rzclk.modules.sys.service.WeixinTokenService;
import top.rzclk.common.utils.PageUtils;
import top.rzclk.common.utils.Query;
import top.rzclk.common.utils.R;




/**
 * 微信Token表
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017-09-20 14:55:21
 */
@RestController
@RequestMapping("sys/weixintoken")
public class WeixinTokenController extends AbstractController {
	@Autowired
	private WeixinTokenService weixinTokenService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys/weixintoken:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WeixinTokenEntity> weixinTokenList = weixinTokenService.queryList(query);
		int total = weixinTokenService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(weixinTokenList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys/weixintoken:info")
	public R info(@PathVariable("id") Integer id){
		WeixinTokenEntity weixinToken = weixinTokenService.queryObject(id);
		
		return R.ok().put("weixinToken", weixinToken);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys/weixintoken:save")
	public R save(@RequestBody WeixinTokenEntity weixinToken){
		weixinTokenService.save(weixinToken);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys/weixintoken:update")
	public R update(@RequestBody WeixinTokenEntity weixinToken){
		weixinTokenService.update(weixinToken);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys/weixintoken:delete")
	public R delete(@RequestBody Integer[] ids){
		weixinTokenService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
