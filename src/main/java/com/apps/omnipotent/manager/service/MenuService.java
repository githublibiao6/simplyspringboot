package com.apps.omnipotent.manager.service;


import com.apps.omnipotent.manager.bean.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> list();
    List<Menu> pagelist();
    boolean add(Menu menu);
    boolean update(Menu menu);
    boolean remove(String id);
    Menu findById(String id);
}
