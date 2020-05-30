package com.apps.omnipotent.manager.dao;

import com.apps.omnipotent.manager.bean.Role;

import java.util.List;

/**
 * 菜单dao
* @Description 
* @MethodName  RoleDao
* @author lb
* @date 2018年8月20日 下午11:14:28
*
 */
public interface RoleDao {

    List<Role> list();

    List<Role> pageList();

    int  add(Role role);

    int  update(Role role);

    Role findById(String id);

    int  remove(String id);

}
