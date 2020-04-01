package com.apps.omnipotent.manager.menu.controller;

import com.apps.omnipotent.manager.menu.mode.Menu;
import com.apps.omnipotent.manager.menu.service.impl.MenuServiceImpl;
import com.apps.omnipotent.system.bean.PageEntity;
import com.apps.omnipotent.system.core.controller.GlobalController;
import com.apps.omnipotent.system.core.model.Result;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("menu")
@Controller
public class MenuController extends GlobalController {

    @Autowired
    MenuServiceImpl service;
    //    @Autowired
    //    DubboService dubboService;

    /**
     * 菜单跳转
     *
     * @return
     */
    @RequestMapping("/index.do")
    public String index() {
        return "system/menu/index";
    }

    /**
     * icon显示
     * @return
     */
    @RequestMapping("/selecticon.do")
    public String selectIcon() {
        return "system/menu/iconshow";
    }

    /**
     * 获取分页菜单
     */
    @RequestMapping("/page")
    @ResponseBody
    public  Result pageList(PageEntity entity) {
        System.err.println(entity.getPage());
        PageEntity page = service.pagelist(entity);
        result.setData(page);
        result.setCode(20000);
        return result;
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
    @RequestMapping("/treelist.do")
    @ResponseBody
    public List<Menu> treeList() {
        List<Menu> list = service.list();
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
    @RequestMapping("/list")
    @ResponseBody
    public Result list() {
//        String hello = dubboService.sayHello("  dubbo "); // 执行远程方法
//        System.out.println(hel1lo);
        System.err.println("222");
        List<Menu> list = service.list();
        System.err.println(list);
        result.setData(list);
        result.setCode(20000);
        result.setMessage("菜单信息");
        return result;
    }

    /**
     * 菜单跳转新增编辑页面
     *
     * @return
     */
    @RequestMapping("/addoreditrender.do")
    public String addOrEditRender() {
        return "system/menu/addoredit";
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public Result add(Menu menu) {
        boolean flag = service.add(menu);
        String msg ;
        result.setSuccess(flag);
        if(flag){
            msg = "添加成功";
        }else {
            msg = "添加失败";
        }
        result.setMessage(msg);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Menu menu) {
        boolean flag = service.update(menu);
        String msg ;
        result.setSuccess(flag);
        if(flag){
            msg = "更新成功";
        }else {
            msg = "更新失败";
        }
        result.setMessage(msg);
        return result;
    }


    @RequestMapping("/findById.do")
    @ResponseBody
    public Result findById(String menuId) {
        Menu menu = service.findById(menuId);
        result.setData(menu);
        return result;
    }
    @RequestMapping("/remove.do")
    @ResponseBody
    public Result remove(String menuId) {
        boolean flag = service.remove(menuId);
        String msg ;
        result.setSuccess(flag);
        if(flag){
            msg = "删除成功";
        }else {
            msg = "删除失败";
        }
        result.setMessage(msg);
        return result;
    }
}