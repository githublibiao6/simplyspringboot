package com.apps.omnipotent.system.core.controller;


import com.alibaba.fastjson.JSONObject;
import com.apps.omnipotent.system.core.model.Result;
import com.apps.omnipotent.system.core.page.LayuiPageHandle;
import com.apps.omnipotent.system.core.page.PageHandle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.List;

public class GlobalController {

    @Autowired
    public HttpServletRequest request;

    @Autowired
    public HttpServletResponse response;

    public Result result = new Result();
    PageHandle layui = new LayuiPageHandle();

    public <T> Result page(List<T> list,Integer page,Integer limit){
        return layui.turnPage(result,list,page,limit);
    }

    /**
     * 获取前台传入的参数
     * @param key
     * @return
     */
    public String getPara(String key){
        return request.getParameter(key);
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
