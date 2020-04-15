package com.apps.omnipotent;

import com.apps.omnipotent.manager.admin.bean.Admin;
import com.apps.omnipotent.manager.menu.mode.Menu;
import com.apps.omnipotent.manager.menu.service.MenuService;
import com.apps.omnipotent.manager.menu.service.impl.MenuServiceImpl;
import com.apps.omnipotent.manager.role.mode.Role;
import com.apps.omnipotent.manager.role.service.RoleService;
import com.apps.omnipotent.manager.role.service.impl.RoleServiceImpl;
import com.apps.omnipotent.system.utils.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
* @Description:  加载后执行
* @Author: cles
* @Date: 2020/4/15 23:29
*/
@Slf4j
@Component
@Order(value = 1)
public class AfterStart implements ApplicationRunner {

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    MenuServiceImpl menuService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动后执行");
        List<Role> list= roleService.list();
        list.forEach(role->{
            String code = role.getCode();
            List<Menu> menuList = menuService.queryByRoleId(code);
            JedisUtil.setList("role"+code,menuList);
        });
    }
}
