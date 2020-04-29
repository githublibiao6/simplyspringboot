package com.apps.omnipotent.system.threadpool.service;
/**
 * Created by cles on 2020/4/28 23:37
 */

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @description:
 * @author cles
 * @Date 2020/4/28 23:37
 */
public interface AsyncService {
    /**
     * 执行异步任务
     */
    void executeAsync();
}
