package com.apps.omnipotent.system.shiro.config;
/**
 * Created by cles on 2020/4/23 22:11
 */

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: shiro配置
 * @Auther cles
 * @Date 2020/4/23 22:11
 */
@Configuration
public class ShiroConfig {
    @Bean
    public Realm realm(){
        TextConfigurationRealm realm=new TextConfigurationRealm();
        realm.setUserDefinitions("sang=123,user\n admin=123,admin");
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;
    }
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chainDefinition=new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/login","anon");
        chainDefinition.addPathDefinition("/doLogin","anon");
        chainDefinition.addPathDefinition("/logout","logout");
        chainDefinition.addPathDefinition("/**","authc");
        return chainDefinition;
    }

    /*@Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }*/
}
