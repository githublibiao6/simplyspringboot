package com.apps.omnipotent.manager.dao;


import com.apps.omnipotent.manager.bean.Menu;

import java.util.List;

/**
 * 菜单dao
* @Description 
* @MethodName  RoleDao
* @author lb
* @date 2018年8月20日 下午11:14:28
*
 */
public interface MenuDao {

    /**
    * @Description: 添加菜单
    * @Param: [menu]
    * @return: int
    * @Author: cles
    * @Date: 2020/6/3 23:43
    */
    int  add(Menu menu);

    List<Menu> list();

    List<Menu> pageList();

    int  update(Menu menu);

    Menu  findById(String id);

    int  remove(String id);

    List<Menu> queryByRoleId(String roleId);
}
