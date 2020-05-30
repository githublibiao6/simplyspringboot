package com.apps.omnipotent.manager.controller;

import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.service.DicService;
import com.apps.omnipotent.manager.service.impl.MenuServiceImpl;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/list")
    @ResponseBody
    public Result list() {
        List<Dictionary> list = dicService.list();
        result.setData(list);
        result.setCode(20000);
        return result;
    }
}
