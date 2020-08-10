package com.ypl;

import cn.hutool.core.util.IdUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
作者：yangp
创建时间：2020/7/31-13:48-2020
*/

public class RedisSessionManagerTest {
    private RedisSessionManager redisSessionManager;
    private SimpleSession session;

    @Before
    public void before() {
        redisSessionManager = new RedisSessionManager();
        session = new SimpleSession("127.0.0.1");
        session.setTimeout(3000);
        session.setAttribute("name", "杨沛霖");
        session.setAttribute("sex", "男");
        session.setAttribute("avl", "http.baiddu.com");
        session.setAttribute("role", "admin,hasDelete");
        session.setId(IdUtil.fastUUID());

    }

    @Test
    public void save() {

        redisSessionManager.save(session);
        System.out.println(session.getId());
    }
@Test
    public void test1() {
        save();
        get();
        update();
        get();
        delete();
        get();
    }

    @Test
    public void delete() {
        redisSessionManager.delete(session);
    }

    @Test
    public void get() {
        Session session = redisSessionManager.get(this.session.getId());
        if(session!=null){
            System.out.println(session.getAttribute("name"));
        }
    }

    @Test
    public void update() {
        session.setAttribute("name", "刘云飞");
        redisSessionManager.update(session);
    }
}