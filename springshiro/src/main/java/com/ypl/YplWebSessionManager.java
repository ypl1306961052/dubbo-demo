package com.ypl;
/*
作者：yangp
创建时间：2020/7/31-11:04-2020
*/


import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import java.io.Serializable;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: YplWebSessionManager
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/31 11:04
 */


public class YplWebSessionManager extends DefaultSessionManager {

    public YplWebSessionManager() {
        super();
        this.sessionDAO=new CachingSessionDAO() {
            @Override
            protected void doUpdate(Session session) {

            }

            @Override
            protected void doDelete(Session session) {

            }

            @Override
            protected Serializable doCreate(Session session) {
                return null;
            }

            @Override
            protected Session doReadSession(Serializable sessionId) {
                return null;
            }
        };
    }
}
