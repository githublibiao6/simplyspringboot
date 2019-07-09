package com.apps.omnipotent.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloSpringboot {

    @RequestMapping("/hello")
    public String say() {
        System.out.println("Hello springboot");
        return "/login";
    }
}
