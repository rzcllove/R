package top.rzclk.modules.job.task;

import java.io.IOException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.rzclk.modules.sys.entity.SysUserEntity;
import top.rzclk.modules.sys.service.SysUserService;
import top.rzclk.modules.test.async.AsyncTask;

/**
 * 测试定时任务(演示Demo，可删除)
 * 
 * testTask为spring bean的名称
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @date 2017年3月30日 下午1:34:24
 */
@Component("testTask")
public class TestTask {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired  
    private AsyncTask asyncTask; 
	
	public void test(String params){
		logger.info("我是带参数的test方法，正在被执行，参数为：" + params);
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SysUserEntity user = sysUserService.queryObject(1L);
		System.out.println(ToStringBuilder.reflectionToString(user));
		
	}
	
	
	public void test2(){
		logger.info("我是不带参数的test2方法，正在被执行");
	}
	
	public void test3() throws InterruptedException, ClientProtocolException, IOException{
		      asyncTask.doTask1();  
	}
}
