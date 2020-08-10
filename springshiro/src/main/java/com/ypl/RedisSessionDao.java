package com.ypl;
/*
作者：yangp
创建时间：2020/7/31-11:07-2020
*/


import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import java.io.Serializable;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: RedisSessionDao
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/31 11:07
 */


public class RedisSessionDao extends CachingSessionDAO {

    public RedisSessionDao() {
        super.setCacheManager(new CacheManager() {
            @Override
            public <K, V> Cache<K, V> getCache(String name) throws CacheException {
                return null;
            }
        });
    }

    /**
     * 策略
     * @param session
     */
    @Override
    protected void doUpdate(Session session) {

    }

    @Override
    protected void doDelete(Session session) {

    }

    @Override
    protected Serializable doCreate(Session session) {
        //当创建session的时候 需要进行保存到 redis中
        return null;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return null;
    }
}
