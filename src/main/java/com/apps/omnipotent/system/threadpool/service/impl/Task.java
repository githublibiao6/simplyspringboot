package com.apps.omnipotent.system.threadpool.service.impl;
/**
 * Created by cles on 2020/4/28 23:38
 */

import com.apps.omnipotent.system.threadpool.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author cles
 * @Date 2020/4/28 23:38
 */

@Component
@Slf4j
public class Task {

    @Async
    public void executeAsync() {
        log.info("start executeAsync");
        try{
            Thread.sleep(10000);
        }catch(Exception e){
            e.printStackTrace();
        }
        log.info("end executeAsync");
    }
}