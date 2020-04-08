package com.apps.omnipotent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Slf4j
@Component
public class BeforeStop {
    @PreDestroy
    public void destory() {
        //System.out.println("<<<<<<<<<<<要销毁的事 begin>>>>>>>>>>>>>>>");
        try {
            log.info("销毁事件");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("<<<<<<<<<<<要销毁的事 end>>>>>>>>>>>>>>>");
    }
}