package com.apps.omnipotent.manager.role.service;

import com.apps.omnipotent.manager.role.mode.Role;

import java.util.List;
import java.util.Set;

/**
* @Description: 角色service
* @Author: cles
* @Date: 2020/4/15 23:48
*/
public interface RoleService {
    List<Role> list();
    List<Role> pagelist();
    boolean add(Role menu);
    boolean update(Role menu);
    boolean remove(String id);
    Role findById(String id);
    Set<String> getRolesByUserId(String id);
}
