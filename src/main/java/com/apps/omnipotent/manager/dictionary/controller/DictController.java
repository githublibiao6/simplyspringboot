package com.apps.omnipotent.manager.dictionary.controller;

import com.apps.omnipotent.manager.dictionary.service.DicService;
import com.apps.omnipotent.manager.menu.service.impl.MenuServiceImpl;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 字典 Controller
 * @author lb
 *
 */
@Controller
@RequestMapping(value = "/dictionary")
public class DictController extends GlobalController {
    
    @Autowired
    private DicService dicService;

    @Autowired
    MenuServiceImpl dbService;


    @RequestMapping("/page")
    @ResponseBody
    public Result pageList(PageEntity entity) {
        PageEntity page = dbService.pagelist(entity);
        result.setData(page);
        result.setCode(20000);
        return result;
    }
}
