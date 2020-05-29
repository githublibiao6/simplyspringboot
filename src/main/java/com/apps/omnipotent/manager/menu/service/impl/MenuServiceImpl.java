package com.apps.omnipotent.manager.menu.service.impl;

import com.apps.omnipotent.manager.menu.dao.MenuDao;
import com.apps.omnipotent.manager.menu.mode.Menu;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.apps.omnipotent.system.global.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class MenuServiceImpl extends GlobalService {

    @Autowired
    MenuDao dao;

    /**
     * 获取菜单
    * @Description
    * @MethodName listMenu
    * @return List<Role>
    * @author lb
    * @date 2018年8月21日 下午9:55:31
    *
     */
    public List<Menu> list() {
        return dao.list();
    }

    /**
     * 分页获取菜单
     * @return
     */
    public PageEntity pagelist(PageEntity entity) {
        List<Menu> pageMenus = dao.pageList();
        pageMenus.forEach(t->{
            t.setHasChildren(false);
        });
        pageMenus.get(0).setHasChildren(true);
        List<Menu> children = new ArrayList<>();
        Menu m = dao.pageList().get(0);
        m.setMenuId("12");
        children.add(m);
        pageMenus.get(0).setHasChildren(true);
        pageMenus.get(0).setChildren(children);
        return getPageEntity(pageMenus,entity);
    }

    public boolean add(Menu menu) {
        menu.setMenuId(UUID.randomUUID().toString());
        boolean flag = true;
        menu.setCreateTime(new Date());
        menu.setCreateUser("");
        menu.setCreateDept("");
        menu.setDeleteFlag("1");
        int num = dao.add(menu);
        if(num > 1){
            flag = false;
        }
        return flag;
    }

    public Menu findById(String menuId){
        return dao.findById(menuId);
    }
    public boolean remove(String menuId){
        boolean flag = true;
        int num = dao.remove(menuId);
        if(num > 1){
            flag = false;
        }
        return flag;
    }
    public boolean update(Menu menu ){
        boolean flag = false;
        menu.setModifyTime(new Date());
        menu.setModifyUser("");
        menu.setModifyDept(" ");
        int num = dao.update(menu);
        if(num > 0){
            flag = true;
        }
        return flag;
    }

    /**
    * @Description: 根据角色code获取菜单
    * @Param: [code]
    * @return: java.util.List<com.apps.omnipotent.manager.menu.mode.Menu>
    * @Author: cles
    * @Date: 2020/4/15 23:34
    */
    public List<Menu> queryByRoleId(String code) {
        return dao.queryByRoleId(code);
    }
}
