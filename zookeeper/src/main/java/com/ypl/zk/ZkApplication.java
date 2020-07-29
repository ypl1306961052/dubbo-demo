package com.ypl.zk;
/*
作者：yangp
创建时间：2020/7/22-18:12-2020
*/


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

import java.security.acl.Acl;
import java.util.ArrayList;
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
//        getChildren();
        createMode();
        new CountDownLatch(1).await();
    }

    private static void getChildren() throws KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZookeeperUtil.createZooKeeper();
        List<String> children = zooKeeper.getChildren("/", true);
        System.out.println(children);
        System.out.println("会话ID:" + zooKeeper.getSessionId());
        System.out.println("获取超时时间：" + zooKeeper.getSessionTimeout());
    }

    public static void createMode() throws KeeperException, InterruptedException {
        /***
         * createMode：节点类型：
         *    EPHEMERAL 临时节点
         *    EPHEMERAL_SEQUENTIAL 临时顺序节点
         *    PERSISTENT 持久节点
         *    PERSISTENT_SEQUENTIAL 持久顺序节点
         */
        ZooKeeper zooKeeper = ZookeeperUtil.createZooKeeper();
        String path = "/07";

        zhuce(zooKeeper, path);
        zooKeeper.removeAllWatches(path, Watcher.WatcherType.Any,false);
        zooKeeper.create(path,
                "000000".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT, new AsyncCallback.StringCallback() {
                    @Override
                    public void processResult(int rc, String path, Object ctx, String name) {
                        System.out.println("rc:" + rc + ",path:" + path + ",ctx:" + ctx + "name," + name);
                    }
                }, 0);
        zooKeeper.setData(path,"1111111".getBytes(),-1);
        List<ACL> acls=new ArrayList<>();
        Id id=new Id("world","anyone");
        ACL acl=new ACL(1,id);
        acls.add(acl);
        String s = zooKeeper.create(path + "/01", "3333333".getBytes(), acls, CreateMode.PERSISTENT);
        System.out.println("s::"+s);
        List<String> children = zooKeeper.getChildren(path, true);
        System.out.println(children);
        for (int i = 0; i < children.size(); i++) {

            zooKeeper.delete(path+"/"+children.get(i),-1);
        }
        zooKeeper.delete(path,-1);


    }

    public static void zhuce(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        zooKeeper.exists(path, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeCreated) {
                    System.out.println("数据被创建了");
                    System.out.println(watchedEvent.getPath());
                } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                    System.out.println(watchedEvent.getPath());
                    System.out.println("数据发生改变了");
                    try {
                        byte[] data = zooKeeper.getData(path, false, null);
                        System.out.println("数据为:");
                        System.out.println(new String(data));
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                    System.out.println(watchedEvent.getPath());
                    System.out.println("数据被删除了");

                } else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                    System.out.println(watchedEvent.getPath());
                    System.out.println("数据子节点发生改变了");
                }
                try {
                    zhuce(zooKeeper, path);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
