package top.rzclk.modules.weixin.controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import top.rzclk.common.annotation.WxLoginLog;
import top.rzclk.common.utils.PojoUtil;
import top.rzclk.common.utils.ToolUtil;
import top.rzclk.common.utils.WxUtil;
import top.rzclk.modules.sys.entity.WeixinUserEntity;
import top.rzclk.modules.sys.service.WeixinUserService;

@RestController
@RequestMapping(value = "/weixin")
public class WeixinLoginController{
	private Logger log = Logger.getLogger(WeixinLoginController.class);
	
	@Autowired
	private WeixinUserService WeixinUserService;
	@Autowired
	private HttpServletRequest HttpServletRequest;
	@WxLoginLog("微信登录")
	@RequestMapping("login")
	public void Login(HttpServletResponse response) throws IOException{
		String beseUrl = URLEncoder.encode(ToolUtil.getBeseUrl(), "utf-8");
		String Appid = ToolUtil.getAPPid();
		String Appsecret = ToolUtil.getAppSecret();
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
		url = String.format(url, Appid,beseUrl,Appsecret);
//		return new ModelAndView("redirect:"+url);
		response.sendRedirect(url);
	}
	@WxLoginLog("微信信息录入")
	@RequestMapping("tologin")
	public ModelAndView toLogin(String code){
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			map = WxUtil.getOpenId(code);
			HashMap<String, Object> weixinMsg = WxUtil.getWeixinMsg(map.get("access_token"), map.get("openid"));
			WeixinUserEntity Weixin_User = PojoUtil.PojoObj(weixinMsg, WeixinUserEntity.class);
			boolean save = WeixinUserService.insert(Weixin_User);
			if(save){
				HttpServletRequest.getSession().setAttribute("weixin_User", Weixin_User);
				return new ModelAndView("redirect:index");
			}else{
				return new ModelAndView("redirect:login");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:login");
		}
	}
	
	@RequestMapping("index")
	public ModelAndView index(){
//		WeixinUserEntity weixin_User = (WeixinUserEntity) HttpServletRequest.getSession().getAttribute("weixin_User");
//		System.out.println(weixin_User.toString());
		return new ModelAndView("index");
	}

}
