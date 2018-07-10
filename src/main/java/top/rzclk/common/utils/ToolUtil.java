package top.rzclk.common.utils;

import top.rzclk.config.RzclProperties;
import top.rzclk.config.WxProperties;

/**
 * @author wangk
 * @qq  1326272899
 * 高频方法集合类
 */
 
public class ToolUtil {
	
	 /**
     * 获取验证码开关
     *
     * @author rzcllove
     * @Date 2017年8月2日 17:16:59
     */
    public static Boolean getKaptchaOnOff(){
        return SpringContextUtils.getBean(RzclProperties.class).getKaptchaOpen();
    }
    /**
     * 获取令牌过期时间
     */
    public static Integer getTokenTimeOut(){
    	return SpringContextUtils.getBean(RzclProperties.class).getTokenTimeout();
    }
    /**
     * token未过期跳转主页面
     */
    public static Boolean getTokenLoginOnOff(){
    	return SpringContextUtils.getBean(RzclProperties.class).getTokenLoginOpen();
    }

    /**
     * 获取wx相关信息
     */
    public static String getAPPid(){
    	return SpringContextUtils.getBean(WxProperties.class).getAppid();
    }
    /**
     * 获取wx相关信息
     */
    public static String getAppSecret(){
    	return SpringContextUtils.getBean(WxProperties.class).getAppSecret();
    }
    
    /**
     * 获取商户号
     */
    public static String getMch_id(){
    	return SpringContextUtils.getBean(WxProperties.class).getMchId();
    }
    
    /**
     * 获取partnerkey
     */
    public static String getPartnerkey(){
    	return SpringContextUtils.getBean(WxProperties.class).getPartnerkey();
    }
    
    /**
     * 获取wx相关信息
     */
    public static String getBeseUrl(){
    	return SpringContextUtils.getBean(WxProperties.class).getBaseUrl();
    }
    
    /**
     * 获取微信access_token
     */
    public static String getAccessToken(){
    	return null;
    }
}

