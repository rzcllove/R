package top.rzclk.common.utils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.catalina.connector.Request;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;




/**
 * 
 * 	   微信支付
 * @author wangk
 * 2017 10 10 整合
 *
 */
/*
 * Map存储值分别为(区分大小写)
 * 	openId         用户唯一ID
 *  Body           内容
 *  OrderId        订单ID
 *  SpbillCreateIp IP
 *  TotalFee       金额
 *  attach         附带数据
 */
public class WxPayUtil {
	private Logger logger = Logger.getLogger(WxPayUtil.class);
	private StringBuilder DebugInfo;
	
	//获取微信支付
	public JSONObject getWxPayInfo(HashMap<String, String> map){
		JSONObject json = new JSONObject();
		if(AssertMap(map)){
			
			return json;
		}else{
			logger.info(DebugInfo);
			return null;
		}
	}
	
	//检验微信支付信息
	public boolean AssertMap(HashMap<String, String> map){
		boolean flat = true;
		if(StringEx.isObjnull(map.get("openId"))){
			DebugInfo.append("-->openId为空<--");
			flat = false;
		}
		if(StringEx.isObjnull(map.get("Body"))){
			DebugInfo.append("-->Body为空<--");
			flat = false;
		}
		if(StringEx.isObjnull(map.get("OrderId"))){
			DebugInfo.append("-->OrderId为空<--");
			flat = false;
		}
		if(StringEx.isObjnull(map.get("SpbillCreateIp"))){
			DebugInfo.append("-->SpbillCreateIp为空<--");
			flat = false;
		}
		if(StringEx.isObjnull(map.get("TotalFee"))){
			DebugInfo.append("-->TotalFee为空<--");
			flat = false;
		}
		if(StringEx.isObjnull(map.get("attach"))){
			DebugInfo.append("-->attach为空<--");
			flat = false;
		}
		
		return flat;
	}
	
	//获取打印信息
	public String GetDebugInfo(){
		return DebugInfo.toString();
	}
	
	public String getPackage(HashMap<String, String> map){
		String appid = ToolUtil.getAPPid();
		String appsecret = ToolUtil.getAppSecret();
		String mch_id = ToolUtil.getMch_id();
		String partnerkey = ToolUtil.getPartnerkey();
		//用户ID
		String openId = map.get("openId");
		// 订单号
		String orderId = map.get("OrderId");
		// 附加数据 原样返回
		String attach = map.get("attach");
		// 总金额以分为单位，不带小数点
		String totalFee = TenpayUtil.getMoney(map.get("totalFee"));
		// 订单生成的机器 IP
		String spbill_create_ip = map.get("SpbillCreateIp");
		//内容
		String body = map.get("Body");
		// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		String notify_url = "";//暂时不需要返回
		//支付类型
		String trade_type = "JSAPI";
		
		// ----------------必须参数---------------
		// 随机字符串
		String nonce_str = TenpayUtil.getNonceStr();
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", orderId);
		packageParams.put("total_fee", totalFee);
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);
		packageParams.put("trade_type", trade_type);
		packageParams.put("openid", openId);
		WxRequestHandler reqHandler = new WxRequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>" 
				+ "<out_trade_no>" + orderId
				+ "</out_trade_no>" + "<attach>" + attach + "</attach>"
				+ "<total_fee>" + totalFee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "<openid>" + openId + "</openid>"
				+ "</xml>";
		String prepay_id = "";
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		
		
		return null;
		
	}
	
	
	 /**
	   * 获取预支付id
	   * @throws IOException 
	   */
	  public static String getPayNo(String url,String xmlParam) throws IOException{
	    //创建httpclient工具对象   
		  return null;
	  }

}
