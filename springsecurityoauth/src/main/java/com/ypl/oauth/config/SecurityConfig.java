package com.ypl.oauth.config;
/*
作者：yangp
创建时间：2020/7/24-11:24-2020
*/


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: SecurityConfig
 * @Package com.ypl.oauth.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/24 11:24
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities(Collections.EMPTY_LIST);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth/*").permitAll()


                .anyRequest().authenticated()
                .and().httpBasic().and().csrf().disable();
    }
}
