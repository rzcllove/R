package top.rzclk.modules.sys.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import top.rzclk.common.annotation.SysLog;
import top.rzclk.common.utils.R;
import top.rzclk.common.utils.ShiroUtils;
import top.rzclk.common.utils.ToolUtil;
import top.rzclk.modules.sys.entity.SysUserEntity;
import top.rzclk.modules.sys.service.SysUserService;
import top.rzclk.modules.sys.service.SysUserTokenService;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * 登录相关
 * @authoryourname wangk
 * @Time 2012-11-20 14:49:01
 *
 */
@RestController
public class SysLoginController {
	private Logger logger = Logger.getLogger(SysLoginController.class);
	@Autowired
	private Producer producer;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserTokenService sysUserTokenService;

	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response)throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//生成文字验证码
		String text = producer.createText();
		//生成图片验证码
		BufferedImage image = producer.createImage(text);
		//保存到shiro session
		ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = "/sys/login", method = RequestMethod.POST)
	public Map<String, Object> login(String username, String password, String captcha)throws IOException {
//		logger.info("验证码开关:"+ToolUtil.getKaptchaOnOff());
		if(ToolUtil.getKaptchaOnOff()){
			String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
			if(!captcha.equalsIgnoreCase(kaptcha)){
				return R.error("验证码不正确");
			}
		}
		//用户信息 
		SysUserEntity user = sysUserService.queryByUserName(username);

		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
			return R.error("账号或密码不正确");
		}

		//账号锁定
		if(user.getStatus() == 0){
			return R.error("账号已被锁定,请联系管理员");
		}

		//生成token，并保存到数据库
		R r = sysUserTokenService.createToken(user.getUserId());
		return r;
	}
	/**
	 * 获取验证码开关
	 * @return 验证码开关状态
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "getcaptcha", method =RequestMethod.POST)
	public R getcaptcha(){
		return new R().ok().put("captcha", ToolUtil.getKaptchaOnOff());
	}
	
	/**
	 * 获取是否跳转主页面
	 */
	@RequestMapping(value = "getTokenLogin",method = RequestMethod.POST)
	public R getTokenLoginOff(){
		return new R().ok().put("tokenLogin", ToolUtil.getTokenLoginOnOff());
	}
	
	
	
	
}
