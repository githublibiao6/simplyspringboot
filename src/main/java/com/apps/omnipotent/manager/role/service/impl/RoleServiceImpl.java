package com.apps.omnipotent.manager.role.service.impl;

import com.apps.omnipotent.manager.role.dao.RoleDao;
import com.apps.omnipotent.manager.role.mode.Role;
import com.apps.omnipotent.manager.role.service.RoleService;
import com.apps.omnipotent.system.global.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao dao;

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
    public List<Role>  pagelist() {
        List<Role>  list = dao.pageList();
        return list;
    }

    @Override
    public boolean add(Role menu) {
        menu.setId(UUID.randomUUID().toString());
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

    @Override
    public Role findById(String menuId){
        return dao.findById(menuId);
    }

    @Override
    public Set<String> getRolesByUserId(String id) {
        // todo 根据admin查询角色
        return null;
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
    public boolean update(Role menu){
        boolean flag = true;
        menu.setModifyTime(new Date());
        menu.setModifyUser(" ");
        menu.setModifyDept("  ");
        int num = dao.update(menu);
        if(num > 1){
            flag = false;
        }
        return flag;
    }
}
