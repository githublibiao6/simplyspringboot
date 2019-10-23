package com.apps.omnipotent.system.controller;

import com.apps.omnipotent.system.bean.Menu;
import com.apps.omnipotent.system.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 菜单controller
* @Description 
* @MethodName  MenuController
* @author lb
* @date 2018年8月20日 下午11:10:32
*
 */
@Controller
@RequestMapping("menu")
public class MenuController{

    @Autowired
    MenuServiceImpl service;

    /**
     * 菜单跳转
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "/vue/login";
    }

    /**
     * icon显示
     * @return
     */
    @RequestMapping("/selecticon")
    public String selectIcon() {
        return "system/menu/iconshow";
    }

    /**
     * 获取分页菜单
     */
    @RequestMapping("/pagelist")
    @ResponseBody
    public  List<Menu> paageList(Integer page, Integer limit) {
        List<Menu>  list = service.pagelist();
        return list;
    }


    /**
     * 获取菜单
     *
     * @return List<Role>
     * @Description
     * @MethodName index
     * @author lb
     * @date 2018年8月21日 下午9:56:33
     */
    @RequestMapping("/treelist")
    @ResponseBody
    public List<Menu> treeList() {
        List<Menu> list = service.list();
        return list;
    }
}