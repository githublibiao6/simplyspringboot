package com.apps.omnipotent.manager.service.impl;

import com.apps.omnipotent.manager.bean.Role;
import com.apps.omnipotent.manager.bean.User;
import com.apps.omnipotent.manager.dao.RoleDao;
import com.apps.omnipotent.manager.dao.UserDao;
import com.apps.omnipotent.manager.service.RoleService;
import com.apps.omnipotent.manager.service.UserService;
import com.apps.omnipotent.system.pagehelper.entity.PageEntity;
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
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;


    @Override
    public PageEntity page(PageEntity entity) {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public boolean add(User m) {
        return false;
    }

    @Override
    public boolean update(User m) {
        return false;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }
}
