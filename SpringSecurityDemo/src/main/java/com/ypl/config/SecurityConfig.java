package com.ypl.config;
/*
作者：yangp
创建时间：2020/7/24-10:47-2020
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: SecurityConfig
 * @Package com.ypl.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/24 10:47
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("ypl")
                .roles("admin")
                .password("123456").
                and().withUser("ypl02").roles("admin01").password("123456");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterAfter(verifyCodeFilter);
        http.authorizeRequests()
                .antMatchers("/hello").hasAnyRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login_view")
                .loginProcessingUrl("/doLogin").
                usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        httpServletResponse.getWriter().println("登录成功");
                        httpServletResponse.getWriter().flush();
                    }
                }).failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                httpServletResponse.getWriter().println("登录失败");
                httpServletResponse.getWriter().flush();
            }
        }).permitAll()
                .and()
                .logout()
                .logoutUrl("login")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        httpServletResponse.getWriter().println("退出成功");
                        httpServletResponse.getWriter().flush();
                    }
                }).permitAll()
                .and().
                httpBasic().and().csrf().disable();





    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
