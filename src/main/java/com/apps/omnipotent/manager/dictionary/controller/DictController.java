package com.apps.omnipotent.manager.dictionary.controller;

import com.apps.omnipotent.manager.dictionary.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 字典 Controller
 * @author lb
 *
 */
@Controller
@RequestMapping(value = "/dic")
public class DictController {
    
    @Autowired
    private DicService dicService;
    

}
