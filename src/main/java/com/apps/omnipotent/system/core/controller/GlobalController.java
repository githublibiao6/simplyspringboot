package com.apps.omnipotent.system.core.controller;


import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.system.core.model.GlobalModel;
import com.apps.omnipotent.system.core.model.Result;
import com.apps.omnipotent.system.core.page.LayuiPageHandle;
import com.apps.omnipotent.system.core.page.PageHandle;

import java.lang.reflect.Field;
import java.util.List;

public class GlobalController {

    public Result result = new Result();
    PageHandle layui = new LayuiPageHandle();

    public <T> Result page(List<T> list,Integer page,Integer limit){
        return layui.turnPage(result,list,page,limit);
    }

    public <T> T getModel(JSONObject json,Class<T> mode) throws IllegalAccessException, InstantiationException {
        Field[] fields = mode.getFields();
        T t = mode.newInstance();
        for(Field s:fields){
            s.setAccessible(true);
            s.set(t,json.get(s.getName()));
        }
        return t;
    }
}
