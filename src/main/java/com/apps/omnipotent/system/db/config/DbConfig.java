package com.apps.omnipotent.system.db.config;
/**
 * Created by cles on 2020/5/6 23:24
 */

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @description: 动态数据源
 * @author cles
 * @Date 2020/5/6 23:24
 */
public class DbConfig extends AbstractRoutingDataSource {
    /*https://blog.csdn.net/ylforever/article/details/79600631*/
    public void test(){

    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DbSourceHolder.getDataSource();
    }
}
