package com.apps.omnipotent.manager.controller;

import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.service.DictionaryService;
import com.apps.omnipotent.manager.service.DictionaryTeamsService;
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
@RequestMapping(value = "dictionaryteams")
public class DictionaryTeamsController extends GlobalController {
    
    @Autowired
    DictionaryService dicService;

    @Autowired
    DictionaryTeamsService teamsService;


    @RequestMapping("/page")
    @ResponseBody
    public Result pageList(PageEntity entity) {
//        PageEntity page = teamsService.pagelist(entity,null);
        result.setData(null);
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
