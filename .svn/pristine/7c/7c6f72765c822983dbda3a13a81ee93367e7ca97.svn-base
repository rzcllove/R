package top.rzclk.modules.weixin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.rzclk.common.utils.R;
import top.rzclk.modules.sys.entity.WeixinShopClassEntity;
import top.rzclk.modules.sys.service.WeixinShopClassService;

@RestController
@RequestMapping(value = "/weixin/class")
public class WeixinClassController {
	
	@Autowired
	private WeixinShopClassService weixinShopClassService;
	
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		List<WeixinShopClassEntity> weixinShopClassList = weixinShopClassService.queryList(null);
		return R.ok().put("list", weixinShopClassList);
	}

}
