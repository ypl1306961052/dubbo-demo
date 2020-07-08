package com.ypl.test.config;
/*
作者：yangp
创建时间：2020/7/8-15:51-2020
*/


import org.apache.shiro.web.servlet.OncePerRequestFilter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: LogFilter
 * @Package com.ypl.test.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/8 15:51
 */


public class LogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

    }

    @Override
    public void setFilterConfig(FilterConfig filterConfig) {
        //初始化kafaka等消息队列
        super.setFilterConfig(filterConfig);
    }

    @Override
    public void destroy() {
    }
}
