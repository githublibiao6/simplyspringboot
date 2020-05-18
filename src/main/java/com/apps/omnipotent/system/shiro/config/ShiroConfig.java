package com.apps.omnipotent.system.shiro.config;
/**
 * Created by cles on 2020/4/27 21:52
 */

import com.apps.omnipotent.manager.menu.service.MenuService;
import com.apps.omnipotent.system.shiro.realm.UserRealm;
import com.apps.omnipotent.system.shiro.service.ShiroService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.support.collections.RedisProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: shiro
 * @Author cles
 * @Date 2020/4/27 21:52
 */
@Configuration
public class ShiroConfig {

    /**
     * 附名后正确运行
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager, ShiroService shiroService){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //设置拦截默认访问，如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/system/interceptLogin");
        //设置登录成功后需要跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/system/welcome");
        // 没有权限的设置
        shiroFilterFactoryBean.setUnauthorizedUrl("/system/unauthorizedUrl");

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        //设置规则
        filterChainDefinitionMap = shiroService.loadFilterChainDefinitions();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /*@Bean
    public CustomRolesAuthorizationFilter rolesAuthorizationFilter() {
        return new CustomRolesAuthorizationFilter();
    }*/


    /**  网上复制的返回类型是SecurityManager，会报错
    * @Description:
    * @Param: []
    * @return: org.apache.shiro.web.mgt.DefaultWebSecurityManager
    * @Author: cles
    * @Date: 2020/4/27 23:29
    */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        manager.setRealm(myRealm());
//        manager.setRealm(realm);
//        多个 realms？
/*        List<Realm> list = new ArrayList<>();
        list.add(myRealm());
        securityManager.setRealms(list);*/
        manager.setSessionManager(sessionManager());
        return manager;
    }

    /**
     * 管理session
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 去掉shiro登录时url里的JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    @Bean(name = "myRealm")
    public UserRealm myRealm(){
        UserRealm myRealm =  new UserRealm();
        return myRealm;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean("defaultAdvisorAutoProxyCreator")
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        //指定强制使用cglib为action创建代理对象
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

   /**
   * @Description:  开启注解
   * @return: org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
   * @Author: cles
   * @Date: 2020/5/15 0:22
   */
    @Bean(name = "sourceAdvisor")
    public AuthorizationAttributeSourceAdvisor sourceAdvisor(){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }

    /**
     * Redis集群使用RedisClusterManager，单个Redis使用RedisManager
     * @param redisProperties
     * @return
     */
    /*@Bean
    public RedisClusterManager redisManager(RedisProperties redisProperties) {
        RedisClusterManager redisManager = new RedisClusterManager();
        redisManager.setHost(redisProperties.getHost());
        redisManager.setPassword(redisProperties.getPassword());
        return redisManager;
    }*/
}