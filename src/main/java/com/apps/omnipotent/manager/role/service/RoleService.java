package com.apps.omnipotent.manager.role.service;

import com.apps.omnipotent.manager.role.mode.Role;

import java.util.List;

public interface RoleService {
    List<Role> list();
    List<Role> pagelist();
    boolean add(Role menu);
    boolean update(Role menu);
    boolean remove(String id);
    Role findById(String id);
}
