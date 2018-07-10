package top.rzclk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目配置
 * @author rzcl
 * @qq 1326272899
 * 具体配置请详细查看application配置修改即可
 */
//指定扫描该包
@Component
@ConfigurationProperties(prefix = RzclProperties.PREFIX)
public class RzclProperties {
	public static final String PREFIX = "rzcl";
	//是否开启验证码
	private Boolean kaptchaOpen = false;
	//token过期时间
	private Integer tokenTimeout = 0;
	//token未过期是否跳转主页面
	private Boolean tokenLoginOpen = false;
	
	public Boolean getKaptchaOpen() {
		return kaptchaOpen;
	}
	public void setKaptchaOpen(Boolean kaptchaOpen) {
		this.kaptchaOpen = kaptchaOpen;
	}
	public Integer getTokenTimeout() {
		return tokenTimeout;
	}
	public void setTokenTimeout(Integer tokenTimeout) {
		this.tokenTimeout = tokenTimeout;
	}
	public Boolean getTokenLoginOpen() {
		return tokenLoginOpen;
	}
	public void setTokenLoginOpen(Boolean tokenLoginOpen) {
		this.tokenLoginOpen = tokenLoginOpen;
	}
	

	
	
	
	
	

}
