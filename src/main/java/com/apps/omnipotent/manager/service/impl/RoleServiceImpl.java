package com.apps.omnipotent.manager.service.impl;

import com.apps.omnipotent.manager.dao.RoleDao;
import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.manager.service.RoleService;
import com.apps.omnipotent.system.global.service.GlobalService;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


/**
 * 菜单service
* @Description
* @MethodName  AdminService
* @author lb
* @date 2018年8月20日 下午11:12:29
*
 */
@Service
public class RoleServiceImpl extends GlobalService implements RoleService {

    @Autowired
    RoleDao dao;

    @Override
    public PageEntity page(PageEntity entity) {
        List<Role> page = dao.list();
        return getPageEntity(page,entity);
    }

    /**
     * 获取全部角色
    * @Description
    * @MethodName listMenu
    * @return List<Role>
    * @author lb
    * @date 2018年8月21日 下午9:55:31
    *
     */
    @Override
    public List<Role> list() {
        return dao.list();
    }


    @Override
    public boolean add(Role role) {
        return role.save();
    }

    @Override
    public Set<String> getRolesByUserId(String id) {
        // todo 根据admin查询角色
        return null;
    }

    @Override
    public boolean remove(String id){
        Role role = new Role();
        role.setId(id);
        return role.delete();
    }
    @Override
    public boolean update(Role role){
        return role.update();
    }

    @Override
    public Role findById(String menuId){
        return dao.findById(menuId);
    }
}
