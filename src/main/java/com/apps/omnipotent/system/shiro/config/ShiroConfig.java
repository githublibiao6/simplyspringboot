package com.apps.omnipotent.system.shiro.config;
/**
 * Created by cles on 2020/4/27 21:52
 */

import com.apps.omnipotent.system.shiro.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //设置拦截默认访问，如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/system/interceptLogin");
        //设置登录成功后需要跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/system/welcome");
        // 没有权限的设置
        shiroFilterFactoryBean.setUnauthorizedUrl("/system/unauthorizedUrl");

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //配置匿名可访问页面和静态文件
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/images/**","anon");
        filterChainDefinitionMap.put("/pic/**","anon");
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/ajaxLogin","anon");
        // 放开登录接口
        filterChainDefinitionMap.put("/**/login","anon");
        filterChainDefinitionMap.put("/**/logout","anon");
        // 测试接口
        filterChainDefinitionMap.put("/test/**","anon");
        // 开放接口
        filterChainDefinitionMap.put("/api/**","anon");
        // 获取信息接口
        filterChainDefinitionMap.put("/user/info","anon");
        filterChainDefinitionMap.put("/menu/list","anon");
//        filterChainDefinitionMap.put("/menu/page","anon");
        filterChainDefinitionMap.put("/logout","logout");
        //过滤器规则，从上而下顺序执行，将/**放在最后
        filterChainDefinitionMap.put("/**","authc");
        //设置规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**  网上复制的返回类型是SecurityManager，会报错
    * @Description:
    * @Param: []
    * @return: org.apache.shiro.web.mgt.DefaultWebSecurityManager
    * @Author: cles
    * @Date: 2020/4/27 23:29
    */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(myRealm());
//        多个 realms？
/*        List<Realm> list = new ArrayList<>();
        list.add(myRealm());
        securityManager.setRealms(list);*/
        securityManager.setSessionManager(sessionManager());
        return securityManager;
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

   /* @Bean(name = "advisorAutoProxyCreator")
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }*/

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

}