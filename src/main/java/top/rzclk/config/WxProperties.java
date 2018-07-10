package top.rzclk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信相关配置信息
 * @author wangk
 * 2017年9月19日21:58:46
 *
 */
//指定扫描该包
@Component
@ConfigurationProperties(prefix = WxProperties.PREFIX)
public class WxProperties {
	public static final String PREFIX = "wx";
	//APPID
	private String appid;
	//appSecret
	private String appSecret;
	//baseUrl
	private String baseUrl;
	//mch_id
	private String mchId;
	//partnerkey
	private String partnerkey;
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getPartnerkey() {
		return partnerkey;
	}
	public void setPartnerkey(String partnerkey) {
		this.partnerkey = partnerkey;
	}
	
	
	
}
