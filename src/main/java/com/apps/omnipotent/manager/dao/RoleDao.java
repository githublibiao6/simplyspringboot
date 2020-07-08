package com.apps.omnipotent.manager.dao;

import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.manager.bean.RoleMenu;

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

    /**
     * 功能描述：
     *  < 获取全部角色 >
     * @Description: list
     * @Author: cles
     * @Date: 2020/7/6 22:17
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Role>
     * @version: 1.0.0
     */
    List<Role> list();

    /**
     * 功能描述：
     *  < 根据主键获取数据 >
     * @Description: findById
     * @Author: cles
     * @Date: 2020/7/6 22:17
     * @param id 参数1
     * @return: com.apps.omnipotent.manager.bean.Role
     * @version: 1.0.0
     */
    Role findById(String id);

    /**
     * 功能描述：
     *  < 根据菜单和角色查询菜单角色关联 >
     * @Description: findByMenuAndRole
     * @Author: cles
     * @Date: 2020/7/8 22:42
     * @param roleId 参数1
     * @return: com.apps.omnipotent.manager.bean.RoleMenu
     * @version: 1.0.0
     */
    List<RoleMenu> findByRoleId(String roleId);
}
