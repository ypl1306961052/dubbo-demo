package com.ypl.test.config;
/*
作者：yangp
创建时间：2020/7/8-15:40-2020
*/


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: ShiroConfig
 * @Package com.ypl.test.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/8 15:40
 */

@Configuration
public class ShiroConfig {
    @Autowired
    CustomRealm customRealm;
    @Value(value = "${spring.application.name:''}")
    public String applicationName;

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customRealm);
        return defaultWebSecurityManager;
    }

    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuthorize");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setLoginUrl("/login");


        Map<String, String> map = new HashMap<>();
        map.put("/" + applicationName + "/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        LogFilter logFilter = new LogFilter();
        FormAuthenticationFilter formAuthenticationFilter=new FormAuthenticationFilter();
        formAuthenticationFilter.setSuccessUrl("/");
        Map<String, Filter> filterMap = new HashMap<>(2);

        filterMap.put("logFilter", logFilter);

        shiroFilterFactoryBean.setFilters(filterMap);


        return shiroFilterFactoryBean;
    }
}
