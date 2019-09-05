package com.apps.omnipotent.system.service.impl;

import com.apps.omnipotent.system.bean.Menu;
import com.apps.omnipotent.system.dao.MenuDao;
import com.apps.omnipotent.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class MenuServiceImpl  implements MenuService {

    @Autowired(required = false)
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

    @Override
    public List<Menu> pagelist() {
        return null;
    }

    @Override
    public boolean add(Menu menu) {
        return false;
    }

    @Override
    public boolean update(Menu menu) {
        return false;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public Menu findById(String id) {
        return null;
    }

}
