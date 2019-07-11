package com.apps.omnipotent.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloSpringboot {

    /**
     * @Author cles
     * @Description 
     * @Date 23:14 2019/7/10
     * @return java.lang.String
     **/
    @RequestMapping("/hello")
    public String say() {
        System.out.println("Hello spr1inqgboo1t");
        return "/login";
    }
}
