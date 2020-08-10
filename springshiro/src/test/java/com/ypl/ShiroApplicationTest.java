package com.ypl;

import cn.hutool.extra.mail.UserPassAuthenticator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

/*
作者：yangp
创建时间：2020/7/31-9:57-2020
*/

public class ShiroApplicationTest {
    @Before
    public void before() {
        serShiroManager();
    }

    @Test
    public void test1() {
        //获取用户信息
        //获取用户对应的角色信息
        //获取用户对应的权限信息

        //我是一工具，什么工具
        //登录/权限的一个工具
        // login logout hasRole isPermitted
        //session的缓存


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken userPassAuthenticator = new UsernamePasswordToken("wang", "123");
        try {
            subject.login(userPassAuthenticator);
        } catch (AuthenticationException e) {

        }
        assertTrue(subject.isAuthenticated());
        subject.logout();

    }

    private void serShiroManager() {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }

    @Test
    public void testSession() {
        Subject subject = SecurityUtils.getSubject();
        //获取会话信息
        Session session = subject.getSession();
        System.out.println(session.getId());
        SecurityManager securityManager = SecurityUtils.getSecurityManager();
    }
}