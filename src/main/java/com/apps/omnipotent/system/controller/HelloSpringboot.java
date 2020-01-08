package com.apps.omnipotent.system.controller;

import com.apps.omnipotent.manager.menu.mode.Menu;
import com.apps.omnipotent.manager.menu.service.MenuService;
import com.apps.omnipotent.system.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloSpringboot {

    @Autowired
    MenuService service;

    /**
     * @Author cles
     * @Description 
     * @Date 23:14 2019/7/10
     * @return java.lang.String
     **/
    @RequestMapping("/index")
    public String say(Menu m, Model model, @RequestParam(value = "s",defaultValue = "1") String s) {
        System.out.println(m.getParent());
        HelloService.me.index();
        List<Menu> list = service.list();
        model.addAttribute("list","list1231");
        model.addAttribute("m",list.get(0));
        System.out.println(list);
        return "/vue/login";
    }
    @RequestMapping("/index2")
    public String react(Menu m, Model model,@RequestParam(value = "s",defaultValue = "1") String s) {
        return "/react/login";
    }
}
