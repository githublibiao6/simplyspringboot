package com.apps.omnipotent.system.service;


import com.apps.omnipotent.system.bean.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> list();
    List<Menu> pagelist();
    boolean add(Menu menu);
    boolean update(Menu menu);
    boolean remove(String id);
    Menu findById(String id);
}
