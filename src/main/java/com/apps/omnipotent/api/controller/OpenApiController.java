package com.apps.omnipotent.api.controller;

import com.apps.omnipotent.manager.menu.service.impl.MenuServiceImpl;
import com.apps.omnipotent.system.core.controller.GlobalController;
import com.apps.omnipotent.system.core.model.Result;
import com.apps.omnipotent.system.utils.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 对外接口
 * @author lib
 */
@Controller
@RequestMapping("/api")
public class OpenApiController extends GlobalController {
    @Autowired
    MenuServiceImpl service;

    @RequestMapping("/index")
    @ResponseBody
    public Result say() {
        result.setSuccess(true);
        result.setData(JedisUtil.getList("list"));
        return result;
    }
}
