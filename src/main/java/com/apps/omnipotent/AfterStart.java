package com.apps.omnipotent;

import com.apps.omnipotent.manager.admin.bean.Admin;
import com.apps.omnipotent.system.utils.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@Order(value = 1)
public class AfterStart implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动后执行");
        JedisUtil.setString("a","3");
        List<Admin> list = new ArrayList<>();
        Admin a = new Admin();
        a.setLoginName("123");
        list.add(a);
        JedisUtil.setList("list",list);
        List<String> aList = JedisUtil.getList("list");
        System.err.println(aList);
    }
}
