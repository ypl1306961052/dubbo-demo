package com.ypl.zk;
/*
作者：yangp
创建时间：2020/7/23-14:19-2020
*/


import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: Zk01
 * @Package com.ypl.zk
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/23 14:19
 */


public class ZookeeperTestGetChildrenNodeSync implements Watcher {
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String ADDRESS = "127.0.0.1:2181";
    private static final String PREFIX_SYNC = "/mytest-sync-getChild-";
    private static   ZooKeeper zooKeeper ;
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper(ADDRESS, 5000, new ZookeeperTestGetChildrenNodeSync());
        countDownLatch.await();
        zooKeeper.create(PREFIX_SYNC, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.create(PREFIX_SYNC + "/c1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(zooKeeper.getChildren(PREFIX_SYNC, true));
        zooKeeper.create(PREFIX_SYNC + "/c2", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(zooKeeper.getChildren(PREFIX_SYNC, true));
        Thread.sleep(1000);
        zooKeeper.create(PREFIX_SYNC + "/c3", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(zooKeeper.getChildren(PREFIX_SYNC, true));
        Thread.sleep(Integer.MAX_VALUE);

    }
    @Override
    public void process(WatchedEvent event) {
        if(Event.KeeperState.SyncConnected == event.getState()){
            if(Event.EventType.None == event.getType() && null == event.getPath()){
                countDownLatch.countDown();
            }else if(Event.EventType.NodeChildrenChanged == event.getType()){
                //监听是一次性 所以 获取到了监听 后需要才重新注册监听
                try {
                    System.out.println("get Child:" + zooKeeper.getChildren(event.getPath(), true));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
