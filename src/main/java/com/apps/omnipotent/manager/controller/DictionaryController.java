package com.apps.omnipotent.manager.controller;

import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.service.DicService;
import com.apps.omnipotent.manager.service.impl.MenuServiceImpl;
import com.apps.omnipotent.system.bean.Record;
import com.apps.omnipotent.system.db.utils.Db;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典 Controller
 * @author lb
 *
 */
@Controller
@RequestMapping(value = "/dictionary")
public class DictionaryController extends GlobalController {
    
    @Autowired
    private DicService dicService;


    @RequestMapping("/list")
    @ResponseBody
    public Result list(PageEntity entity) {
        List<Record> list = Db.use().find("select t.id, t.name label  from be_dictionary t ");
        Map root = new HashMap();
        root.put("id",0);
        root.put("label","数据字典");
        root.put("children",list);
        List<Map> data = new ArrayList<>();
        data.add(root);
        result.setData(data);
        result.setCode(20000);
        return result;
    }
}
