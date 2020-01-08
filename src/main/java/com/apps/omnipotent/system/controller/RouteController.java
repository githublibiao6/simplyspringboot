package com.apps.omnipotent.system.controller;

import com.apps.omnipotent.manager.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    MenuService service;

    /**
     * 主路径
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }
}
