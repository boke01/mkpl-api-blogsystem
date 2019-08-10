package com.newegg.mkpl.api.blogsystem.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类
 * @author vz04
 * @date 8/10/2019 12:30 PM
 **/
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     *
     * @date 12:46 PM 8/10/2019
     * @param securityManager DefaultWebSecurityManager
     * @return ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         * Shiro内置过滤器，实现权限相关的拦截
         *      常用过滤器：
         *          anon：无需认证（登录）可以访问
         *          authc：必须认证才能访问
         *          user：如果使用rememberMe的功能可以直接访问
         *          perms：该资源必须得到资源授权才能访问
         *          role：该资源必须得到角色权限才能访问
         */
        Map<String,String> filterMap= new LinkedHashMap<>();
        shiroFilterFactoryBean.setLoginUrl("/manage/limits");
        filterMap.put("/manage/login","anon");
        filterMap.put("/manage/*/*","authc");
        filterMap.put("/manage/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     *
     * @date 12:38 PM 8/10/2019
     * @param userRealm UserRealm
     * @return DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     *
     * @date 12:37 PM 8/10/2019
     * @return UserRealm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
}
