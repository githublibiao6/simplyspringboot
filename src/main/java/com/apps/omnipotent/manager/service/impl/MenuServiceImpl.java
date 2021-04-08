package com.apps.omnipotent.manager.service.impl;

import com.apps.omnipotent.manager.dao.MenuDao;
import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.manager.service.MenuService;
import com.apps.omnipotent.system.global.service.impl.GlobalServiceImpl;
import com.apps.omnipotent.system.pagehelper.entity.qo.MenuQo;
import com.apps.omnipotent.system.utils.ConvertUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


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
    public List<Menu> list(MenuQo qo) {
        return dao.list(qo);
    }

    @Override
    public List<Menu> list() {
        return dao.list2();
    }

    @Override
    public List<Map> listMap() {
        List<Map> list = dao.listMap();
        ConvertUtils.convertTree(list,"menu_id","parent","children","-1",true);
        return list;
    }

    @Override
    public PageInfo page(MenuQo qo) {
        PageHelper.offsetPage(qo.getPage(), qo.getLimit());
        return new PageInfo(dao.list(qo));
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
    public List<Menu> tree(MenuQo qo) {
        List<Menu> list = list(qo);
        convertMenuTree(list, "-1");
        return list.stream().filter(s-> "-1".equals(s.getParent())).collect(Collectors.toList());
    }

    private void convertMenuTree(List<Menu> list,  String pid){
        list.forEach(t->{
            List<Menu> children = new ArrayList<>();
            if(pid.equals(t.getParent())){
                for (Menu record : list) {
                    if(record.getParent().equals(t.getMenuId())){
                        children.add(record);
                    }
                }
                if(children.size() > 0){
                    children.forEach(child->{
                        convertMenuTree(list, t.getMenuId());
                    });
                    t.setChildren(children);
                    t.setHasChildren(true);
                }else {
                    t.setHasChildren(false);
                }
            }
        });
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
