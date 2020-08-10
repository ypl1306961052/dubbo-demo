package com.ypl.session.listen;
/*
作者：yangp
创建时间：2020/7/31-14:17-2020
*/


import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: CurtomSessionListen
 * @Package com.ypl.session.listen
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/31 14:17
 */


public class CurtomSessionListen implements SessionListener {
    @Override
    public void onStart(Session session) {
        System.out.println("会话开始创建了");
        System.out.println(session.getId());
    }

    @Override
    public void onStop(Session session) {
        System.out.println("会话结束了");
        System.out.println(session.getId());

    }

    @Override
    public void onExpiration(Session session) {
        System.out.println("会话超时");
        System.out.println(session.getId());
    }
}
