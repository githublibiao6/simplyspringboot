package com.apps.omnipotent.system.core.controller;


import com.apps.omnipotent.system.core.model.Result;
import com.apps.omnipotent.system.core.page.LayuiPageHandle;
import com.apps.omnipotent.system.core.page.PageHandle;

import java.util.List;

public class GlobalController {

    public Result result = new Result();
    PageHandle layui = new LayuiPageHandle();

    public <T> Result page(List<T> list,Integer page,Integer limit){
        return layui.turnPage(result,list,page,limit);
    }
}
