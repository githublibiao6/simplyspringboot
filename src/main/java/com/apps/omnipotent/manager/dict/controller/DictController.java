package com.apps.omnipotent.manager.dict.controller;

import com.apps.omnipotent.manager.dict.service.DictObjService;
import com.apps.omnipotent.manager.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 字典 Controller
 * @author lb
 *
 */
@Controller
@RequestMapping(value = "/dict")
public class DictController {
    
    @Autowired
    private DictService dictService;
    @Autowired
    private DictObjService dictObjService;
    

}
