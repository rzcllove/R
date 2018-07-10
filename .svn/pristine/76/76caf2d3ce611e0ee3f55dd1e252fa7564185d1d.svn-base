package top.rzclk.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import top.rzclk.common.annotation.SysLog;
import top.rzclk.common.annotation.WxLog;
import top.rzclk.common.utils.HttpContextUtils;
import top.rzclk.common.utils.IPUtils;
import top.rzclk.modules.sys.entity.SysLogEntity;
import top.rzclk.modules.sys.entity.SysUserEntity;
import top.rzclk.modules.sys.entity.WeixinLogEntity;
import top.rzclk.modules.sys.service.WeixinLogService;

/**
 * 微信日志，切面处理类
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @Time 2017年9月20日12:38:59
 *
 */

@Aspect
@Component
public class WxLogAspect {

	@Autowired
	private WeixinLogService weixinLogService;
	
	@Pointcut("@annotation(top.rzclk.common.annotation.WxLog)")
	public void logPointCut() { 
		
	}
	
	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;

		//保存日志
		saveWxLog(point, time);

		return result;
	}
	
	private void saveWxLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		WeixinLogEntity WxLog = new WeixinLogEntity();
		WxLog WeixinLog = method.getAnnotation(WxLog.class);
		if(WeixinLog != null){
			//注解上的描述
			WxLog.setOperation(WeixinLog.value());
		}

		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		WxLog.setMethod(className + "." + methodName + "()");

		
		//请求的参数
		Object[] args = joinPoint.getArgs();
		try{
			String params = new Gson().toJson(args[0]);
			WxLog.setParams(params);
		}catch (Exception e){

		}

		//获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//设置IP地址
		WxLog.setIp(IPUtils.getIpAddr(request));

		//用户名
		String username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
		WxLog.setUsername(username);

		WxLog.setTime(time);
		WxLog.setCreateDate(new Date());
		//保存系统日志
		weixinLogService.save(WxLog);
	}
}
