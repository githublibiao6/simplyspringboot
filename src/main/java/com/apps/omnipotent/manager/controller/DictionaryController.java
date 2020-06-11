package com.apps.omnipotent.manager.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.manager.bean.Dictionary;
import com.apps.omnipotent.manager.service.DictionaryService;
import com.apps.omnipotent.manager.service.impl.MenuServiceImpl;
import com.apps.omnipotent.system.bean.Record;
import com.apps.omnipotent.system.db.utils.Db;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.mysql.cj.xdevapi.JsonArray;
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
    private DictionaryService dicService;

    @RequestMapping("/add.do")
    @ResponseBody
    public Result add(Dictionary m) {
        boolean flag = dicService.add(m);
        result.setSuccess(flag);
        if(flag){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        return result;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Result list(PageEntity entity) {
//        dicService.list();
        // todo
        List<Map> list = Db.use().find("select t.id, t.name label  from be_dictionary t ");
        List<Record> records = Db.use().findRecord("select t.id, t.name label  from be_dictionary t ");
        List<JSONObject> test = new ArrayList<>();
        records.forEach(t->{
            Map<String, Object> map = t.getColumns();
            JSONObject obj = new JSONObject();
            map.forEach(obj::put);
            test.add(obj);
        });
        Map root = new HashMap();
        root.put("id",0);
        root.put("label","数据字典");
        root.put("children", list);
        List<Map> data = new ArrayList<>();
        data.add(root);
        result.setData(data);
        result.setData(records);
        System.err.println(result.toString());
        result.setCode(20000);
        return result;
    }
}
