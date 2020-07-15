package com.apps.omnipotent.business.controller;

import com.apps.omnipotent.business.service.AlipayService;
import com.apps.omnipotent.business.service.impl.AlipayServiceImpl;
import com.apps.omnipotent.manager.service.ProjectService;
import com.apps.omnipotent.system.utils.EVMUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 支付 controller
 * @author lb
 * @date 2018年6月24日 下午6:58:58
 */
@RequestMapping("pay")
@Controller
public class AlipayController {

    @Autowired
    AlipayServiceImpl service;
    /** 测试异步执行
     * @Author cles
     * @Description
     * @Date 23:14 2019/7/10
     * @return java.lang.String
     **/
    @RequestMapping("/index")
    @ResponseBody
    public void index() {

        service.index();
    }
    
}
