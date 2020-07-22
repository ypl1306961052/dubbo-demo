package com.ypl.zk;
/*
作者：yangp
创建时间：2020/7/22-18:12-2020
*/


import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: ZkApplicaiton
 * @Package com.ypl.zk
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/22 18:12
 */


public class ZkApplication {
    public static void main(String[] args) throws KeeperException, InterruptedException {
        getChildren();
        new CountDownLatch(1).await();
    }

    private static void getChildren() throws KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZookeeperUtil.createZooKeeper();
        List<String> children = zooKeeper.getChildren("/", true);
        System.out.println(children);
        System.out.println("会话ID:"+zooKeeper.getSessionId());
        System.out.println("获取超时时间："+zooKeeper.getSessionTimeout());
    }

    public void createMode() throws KeeperException, InterruptedException {
        /***
         * createMode：节点类型：
         *    EPHEMERAL 临时节点
         *    EPHEMERAL_SEQUENTIAL 临时顺序节点
         *    PERSISTENT 持久节点
         *    PERSISTENT_SEQUENTIAL 持久顺序节点
         */
        ZooKeeper zooKeeper = ZookeeperUtil.createZooKeeper();
        zooKeeper.create("/test02",
                "杨沛霖".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT, new AsyncCallback.StringCallback() {
                    @Override
                    public void processResult(int i, String s, Object o, String s1) {
                        System.out.println(i);
                    }
                },0);
    }

}
