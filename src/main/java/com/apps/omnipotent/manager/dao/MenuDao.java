package com.apps.omnipotent.manager.dao;


import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.system.pagehelper.entity.qo.MenuQo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 菜单dao
* @Description 
* @MethodName  RoleDao
* @author lb
* @date 2018年8月20日 下午11:14:28
*
 */
@Component
public interface MenuDao {

    /**
     * 功能描述：添加菜单
     *  < >
     * @Description: add
     * @Author: cles
     * @Date: 2020/8/26 23:31
     * @param menu 参数1
     * @return: int
     * @version: 1.0.0
     */
    int  add(Menu menu);
    /**
     * 功能描述：获取所有菜单
     *  < >
     * @Description: list
     * @Author: cles
     * @param qo
     * @Date: 2020/8/26 23:31
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
     * @version: 1.0.0
     */
    @Select("select t.* from be_menu t where sys005='1' order by level asc")
    List<Menu> list(MenuQo qo);

    /**
     * 功能描述：获取所有菜单
     *  < >
     * @Description: list
     * @Author: cles
     * @Date: 2020/8/26 23:31
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
     * @version: 1.0.0
     */
    @Select("select t.* from be_menu t where sys005='1' order by level asc")
    List<Menu> list2();

    /**
     * 功能描述：获取所有有效菜单
     *  < >
     * @Description: listMap
     * @Author: cles
     * @Date: 2020/8/26 23:31
     * @return: java.util.List<java.util.Map>
     * @version: 1.0.0
     */
    @Select("select t.* from be_menu t where sys005 = 1")
    List<Map> listMap();

    /**
     * 功能描述：
     *  < >
     * @Description: update
     * @Author: cles
     * @Date: 2020/8/26 23:30
     * @param menu 参数1
     * @return: int
     * @version: 1.0.0
     */
    int  update(Menu menu);

    /**
     * 功能描述：根据抓紧查询
     *  < >
     * @Description: findById
     * @Author: cles
     * @Date: 2020/8/26 23:30
     * @param id 参数1
     * @return: com.apps.omnipotent.manager.bean.Menu
     * @version: 1.0.0
     */
    Menu  findById(String id);

    /**
     * 功能描述：删除
     *  < >
     * @Description: remove
     * @Author: cles
     * @Date: 2020/8/26 23:30
     * @param id 参数1
     * @return: int
     * @version: 1.0.0
     */
    int  remove(String id);

    /**
     * 功能描述：根据角色获取菜单
     *  < >
     * @Description: queryByRoleId
     * @Author: cles
     * @Date: 2020/8/26 23:30
     * @param roleId 参数1
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
     * @version: 1.0.0
     */
    @Select("select t.* from be_menu t where sys005='1' and t.menu_id in (select m.menu_id from  be_role_menu m where role_id= #{roleId})")
    List<Menu> queryByRoleId(String roleId);
}
