package com.apps.omnipotent.system.controller;

import com.apps.omnipotent.manager.menu.mode.Menu;
import com.apps.omnipotent.manager.menu.service.impl.MenuServiceImpl;
import com.apps.omnipotent.system.core.controller.GlobalController;
import com.apps.omnipotent.system.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/permission")
public class PermissionController extends GlobalController {
    @Autowired
    MenuServiceImpl service;

    @RequestMapping("/index")
    @ResponseBody
    public Result say(@RequestParam(value = "s",defaultValue = "1") String s) {
        System.err.println(2000);
        /*HashMap map = new HashMap();
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction","I am a super administrator");
        map.put("name","Super Admin");
        String[] roles= {"admin"};
        map.put("roles",roles);*/
        List<Menu> list = service.list();
        result.setCode(20000);
        result.setData(list);
        result.setMessage("菜单查询信息");
        return result;
    }
}
