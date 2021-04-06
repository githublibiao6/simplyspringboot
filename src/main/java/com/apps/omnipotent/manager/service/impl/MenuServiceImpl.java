package com.apps.omnipotent.manager.service.impl;

import com.apps.omnipotent.manager.dao.MenuDao;
import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.manager.service.MenuService;
import com.apps.omnipotent.system.core.BaseModel;
import com.apps.omnipotent.system.db.utils.Db;
import com.apps.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.pagehelper.entity.qo.MenuQo;
import com.apps.omnipotent.system.utils.ConvertUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 菜单service
* @Description
* @MethodName  MenuServiceImpl
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class MenuServiceImpl extends GlobalServiceImpl<Menu> implements MenuService {

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
    @Override
    public List<Menu> list() {
        return dao.list();
    }

    @Override
    public List<Map> listMap() {
        List<Map> list = dao.listMap();
        ConvertUtils.convertTree(list,"menuId","parent","children","-1",true);
        return list;
    }

    /**
     * 功能描述：
     *  < 分页获取菜单 >
     * @Description: pageList
     * @Author: cles
     * @Date: 2020/6/23 23:00
     * @param qo 参数1
     * @return: com.apps.omnipotent.system.pagehelper.entity.PageEntity
     * @version: 1.0.0
     */
    @Override
    public PageInfo page(MenuQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        return new PageInfo(dao.list());
        /*List<Menu> pageMenus = dao.pageList();
        if(pageMenus.size() == 0){
            return null;
        }
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
        return getPageEntity(pageMenus,entity);*/
    }

    @Override
    public boolean add(Menu menu) {
        menu.setMenuId(UUID.randomUUID().toString());
        boolean flag = true;
        int num = dao.add(menu);
        if(num > 1){
            flag = false;
        }
        return flag;
    }

    @Override
    public Menu findById(String menuId){
        Menu m = detailQuery(menuId, Menu.class);
        System.err.println(m);
        return m;
    }

    @Override
    public boolean remove(String menuId){
        boolean flag = true;
        int num = dao.remove(menuId);
        if(num > 1){
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean update(Menu menu ){
        boolean flag = false;
        int num = dao.update(menu);
        if(num > 0){
            flag = true;
        }
        return flag;
    }

    /**
    * @Description: 根据角色code获取菜单
    * @Param: [code]
    * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
    * @Author: cles
    * @Date: 2020/4/15 23:34
    */
    public List<Menu> queryByRoleId(String code) {
        return dao.queryByRoleId(code);
    }
}
