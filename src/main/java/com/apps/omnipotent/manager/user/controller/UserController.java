package com.apps.omnipotent.manager.user.controller;

import com.apps.omnipotent.system.shiro.entity.Permissions;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * user controller
 * @author lb
 * @date 2018年6月5日 下午8:56:11
 */
@RequestMapping("user")
@Controller
public class UserController extends GlobalController {
    
    /**
     * 菜单跳转
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(String username,String password) {
        result.setCode(20000);
        HashMap map = new HashMap();
        map.put("token","admin-token");
        result.setData(map);
        return result;
    }

    @RequestMapping("/info")
    @ResponseBody
    public Result info(String token) {
        Permissions permissions1 = new Permissions("1","query");
        Permissions permissions2 = new Permissions("2","add");
        Set<Permissions> permissionsSet = new HashSet<>();
        System.out.println(token);
        HashMap map = new HashMap();
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction","I am a super administrator");
        map.put("name","Super Admin");
        String[] roles= {"admin"};
        map.put("roles",roles);
        result.setCode(20000);
        result.setData(map);
        System.out.println(map);
        System.out.println(roles[0]);
        result.setMessage("用户查询信息");
        return result;
    }
    @RequestMapping("/logout")
    @ResponseBody
    public Result out(String token) {
        result.setCode(20000);
        result.setMessage("用户退出");
        return result;
    }

    @RequestMapping("/resetToken")
    @ResponseBody
    public Result resetToken(String token) {
        result.setCode(20000);
        result.setSuccess(true);
        result.setMessage("用户重置");
        return result;
    }

}
