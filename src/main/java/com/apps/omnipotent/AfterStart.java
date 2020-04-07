package com.apps.omnipotent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Slf4j
@Component
@Order(value = 1)
public class AfterStart implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动后执行");
        // 以下方法并非一定执行,根据版本升级情况决定是否执行,某些数据未产生变动不需执行,此处执行方法目的是为了解决缓存数据一致性问题
        // 同步缓存中的通知消息数目
    }
}
