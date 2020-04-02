package com.apps.omnipotent.manager.menu.service.impl;

import com.apps.omnipotent.manager.menu.dao.MenuDao;
import com.apps.omnipotent.manager.menu.mode.Menu;
import com.apps.omnipotent.system.bean.PageEntity;
import com.apps.omnipotent.system.core.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(num > 1){
            flag = true;
        }
        return flag;
    }
}
