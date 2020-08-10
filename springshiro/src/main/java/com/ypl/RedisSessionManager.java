package com.ypl;
/*
作者：yangp
创建时间：2020/7/31-11:19-2020
*/


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Editor;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.zookeeper.data.ACL;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.*;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: RedisManager
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/31 11:19
 */


public class RedisSessionManager {
    public  String redisKeyPrefix="risk_session:";
    private String ip;
    private int port;
    private Jedis jedis;
    //单位 秒默认为 60*30
    private long defaultTimeout = 60 * 30;

    public RedisSessionManager(String redisKeyPrefix, String ip, int port) {
        this.redisKeyPrefix = redisKeyPrefix;
        this.ip = ip;
        this.port = port;
    }

    public String getRedisKeyPrefix() {
        return redisKeyPrefix;
    }

    public void setRedisKeyPrefix(String redisKeyPrefix) {
        this.redisKeyPrefix = redisKeyPrefix;
    }

    public RedisSessionManager() {
        this.ip = "127.0.0.1";
        this.port = 6379;
        jedis = new Jedis(ip, port);
    }

    public void save(Session session) {
        Serializable id = session.getId();
        Map<String, String> map = new HashMap<>();
        map.put("Serializable", session.getId() + "");
        map.put("timeout", session.getTimeout() + "");
        map.put("host", session.getHost());
        Collection<Object> attributeKeys = session.getAttributeKeys();
        for (Object attributeKey : attributeKeys) {
            Object attribute = session.getAttribute(attributeKey);
            if (attribute instanceof String) {
                map.put("m_" + attributeKey, attribute.toString());
            }

        }
        jedis.hset(id + "", map);
        if (session.getTimeout() != 0) {
            defaultTimeout = session.getTimeout() / 1000;
        }
        jedis.expire(id + "", (int) defaultTimeout);
    }

    public void delete(Session session) {
        jedis.del(session.getId() + "");
    }

    public Session get(Serializable sessionId) {
        Map<String, String> stringStringMap = jedis.hgetAll(sessionId + "");
        if(stringStringMap.isEmpty()){
            return null;
        }
        String host = stringStringMap.get("host");
        String timeout = stringStringMap.get("timeout");
        Session session = new SimpleSession(host);
        session.setTimeout(Long.parseLong(timeout));
        stringStringMap.keySet().forEach(t -> {
            if (t.indexOf("m_") == 0) {
                String value = stringStringMap.get(t);
                String key = t.replace("m_", "");
                session.setAttribute(key, value);
            }
        });
        return session;
    }

    public void update(Session session) {
        //先删除 然后保存
        delete(session);
        save(session);
    }

}
