package com.apps.omnipotent.system.db.config;
/**
 * Created by cles on 2020/5/31 18:29
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.apps.omnipotent.system.db.utils.Db;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 默认数据源加入DB
 * @author cles
 * @Date 2020/5/31 18:29
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class MainDb {
    private String url;
    private String username;
    private String password;
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // application.properteis中对应属性的前缀
    @Bean(name = "main_db")
    public void dataSource() {
        DbConfig db = new DbConfig();
        System.err.println(url);
        DruidDataSource druidDataSource = db.buildDataSource(url,username,password,null);
        Db.setMain(druidDataSource);

    }
}
