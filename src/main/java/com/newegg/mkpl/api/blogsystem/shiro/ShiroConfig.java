package com.newegg.mkpl.api.blogsystem.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类
 *
 * @author vz04
 * @date 8/10/2019 12:30 PM
 **/
@Configuration
public class ShiroConfig {


    /**
     * 创建ShiroFilterFactoryBean
     *
     * @param securityManager DefaultWebSecurityManager
     * @return ShiroFilterFactoryBean
     * @date 12:46 PM 8/10/2019
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        filters.put("authc", new ShiroLoginFilter());

        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/manage/login", "anon");
        filterMap.put("/manage/*/*", "authc");
        filterMap.put("/manage/*", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     *
     * @param userRealm UserRealm
     * @return DefaultWebSecurityManager
     * @date 12:38 PM 8/10/2019
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
     * @return UserRealm
     * @date 12:37 PM 8/10/2019
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
}
