package top.rzclk.modules.api.controller;


import org.springframework.web.bind.annotation.*;

import top.rzclk.common.utils.R;
import top.rzclk.modules.api.annotation.AuthIgnore;
import top.rzclk.modules.api.annotation.LoginUser;
import top.rzclk.modules.api.entity.TokenEntity;
import top.rzclk.modules.api.entity.UserEntity;

/**
 * API测试接口
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @Time 2017年8月9日 下午5:33:31 
 *
 */
@RestController
@RequestMapping("/api")
public class ApiTestController {

    /**
     * 获取用户信息
     */
    @GetMapping("userInfo")
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    /**
     * 忽略Token验证测试
     */
    @AuthIgnore
    @GetMapping("notToken")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

    /**
     * 接收JSON数据
     */
    @PostMapping("jsonData")
    public R jsonData(@LoginUser UserEntity user, @RequestBody TokenEntity token){
        return R.ok().put("user", user).put("token", token);
    }
}
