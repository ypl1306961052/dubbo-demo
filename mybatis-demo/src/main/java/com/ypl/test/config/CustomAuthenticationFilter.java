package com.ypl.test.config;
/*
作者：yangp
创建时间：2020/7/8-16:18-2020
*/


import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: CustomAuthenticationFilter
 * @Package com.ypl.test.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/8 16:18
 */


public class CustomAuthenticationFilter extends AuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
