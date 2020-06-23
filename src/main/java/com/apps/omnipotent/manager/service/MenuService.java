package com.apps.omnipotent.manager.service;


import com.apps.omnipotent.manager.bean.Menu;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;

import java.util.List;

/**
 * 功能描述：
 *  < 菜单service >
 * @Description:
 * @Author: cles
 * @Date: 2020/6/23 22:55
 * @return:
 * @version: 1.0.0
 */
public interface MenuService {
    /**
     * 功能描述：
     *  < >
     * @Description: list
     * @Author: cles
     * @Date: 2020/6/23 22:54
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
     * @version: 1.0.0
     */
    List<Menu> list();
    /**
     * 功能描述：
     *  < 分页 >
     * @Description: pagelist
     * @Author: cles
     * @param entity
     * @Date: 2020/6/23 22:54
     * @return: java.util.List<com.apps.omnipotent.manager.bean.Menu>
     * @version: 1.0.0
     */
    PageEntity page(PageEntity entity);
    /**
     * 功能描述：
     *  < 新增菜单 >
     * @Description: add
     * @Author: cles
     * @Date: 2020/6/23 22:54
     * @param menu 参数1
     * @return: boolean
     * @version: 1.0.0
     */
    boolean add(Menu menu);
    boolean update(Menu menu);
    boolean remove(String id);
    Menu findById(String id);
}
