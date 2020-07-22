package com.ypl.zk;
/*
作者：yangp
创建时间：2020/7/22-18:09-2020
*/


import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZKUtil;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: ZookeeperUtil
 * @Package com.ypl.zk
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/22 18:09
 */


public class ZookeeperUtil {

    public static  ZooKeeper createZooKeeper(){
        CustomWatcher customWatcher=new CustomWatcher();
        ZooKeeper zk=null;
        try {
            zk=new ZooKeeper("127.0.0.1:2181",10000,customWatcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zk;

    }
    static class CustomWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent.getState());
        }
    }
}
