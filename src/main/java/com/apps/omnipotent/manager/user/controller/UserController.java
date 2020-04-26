package com.apps.omnipotent.manager.user.controller;

import com.apps.omnipotent.manager.admin.bean.Admin;
import com.apps.omnipotent.system.shiro.entity.Permissions;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

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
        // shiro 调用
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        try{
            //重点！！！！！！
            //getAuthenticationInfo 执行时机
            // 会触发 Realm的doGetAuthenticationInfo方法
            subject.login(token);
            Session session = subject.getSession();
        }catch (Exception e){
            e.printStackTrace();
        }
        //重点！！！！！！
        //        subject.hasRole(“admin”)
        //        subject.isPermitted(“admin”)
        //        @RequiresRoles(“admin”) ：在方法上加注解的时候；
        //getAuthorizationInfo  执行时机 -- subject.hasRole()
        if (subject.hasRole("admin")) {
//            return "redirect:/admin/showComputerProblems";
        } else if (!subject.hasRole("admin")) {
//            return "redirect:/normal/showComputerProblems";
        }
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
