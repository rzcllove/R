package top.rzclk.modules.test.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 测试数据
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @Time 2017-08-08 18:26:40
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.rzclk.common.utils.R;
import top.rzclk.modules.test.service.TestService;
@RestController
@RequestMapping(value = {"/test/"})
public class TestController {
	@Autowired
	private TestService testService;
	
	/**
	 * 所有列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	public R list(){
		return new R().put("list", testService.findList());
	}

}
