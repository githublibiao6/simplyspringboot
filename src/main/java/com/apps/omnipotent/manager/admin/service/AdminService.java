package com.apps.omnipotent.manager.admin.service;

import com.apps.omnipotent.manager.admin.bean.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> list();
    List<Admin> pagelist();
    boolean add(Admin menu);
    boolean update(Admin menu);
    boolean remove(String id);
    Admin findById(String id);
}
