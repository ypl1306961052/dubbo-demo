package com.ypl.zk;
/*
作者：yangp
创建时间：2020/7/22-18:09-2020
*/


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.file.Path;

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
    public static  ZooKeeper createZooKeeper(Watcher watcher){
        ZooKeeper zk=null;
        try {
            zk=new ZooKeeper("127.0.0.1:2181",10000,watcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zk;

    }
    public static class CustomWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent.getState());
            if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
                System.out.println("链接成功");
            }else if(watchedEvent.getType()==Event.EventType.NodeChildrenChanged){
                System.out.println("子节点发生改变");
                System.out.println(watchedEvent.getPath());
            }
        }

    }

    /**
     * 注册监听
     * @param zooKeeper
     * @param path
     * @param watcher
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void  registerZkListen(ZooKeeper zooKeeper, String path,Watcher watcher) throws KeeperException, InterruptedException {
        if(watcher==null){
            zooKeeper.exists(path,true);
        }
        zooKeeper.exists(path,watcher);
    }

    /**
     * cZxid：这是导致创建znode更改的事务ID。
     * mZxid：这是最后修改znode更改的事务ID。
     * pZxid：这是用于添加或删除子节点的znode更改的事务ID。
     * ctime：表示从1970-01-01T00:00:00Z开始以毫秒为单位的znode创建时间。
     * mtime：表示从1970-01-01T00:00:00Z开始以毫秒为单位的znode最近修改时间。
     * dataVersion：表示对该znode的数据所做的更改次数。
     * cversion：这表示对此znode的子节点进行的更改次数。
     * aclVersion：表示对此znode的ACL进行更改的次数。
     * ephemeralOwner：如果znode是ephemeral类型节点，则这是znode所有者的 session ID。 如果znode不是ephemeral节点，则该字段设置为零。
     * dataLength：这是znode数据字段的长度。
     * numChildren：这表示znode的子节点的数量。
     * @param stat
     */
    public static void print(Stat stat){
        System.out.println("version:"+stat.getVersion());
        System.out.println("创建会话ID:"+stat.getCzxid());
        System.out.println("当前会话ID:"+stat.getMzxid());
        System.out.println("子节点会话ID:"+stat.getPzxid());
        System.out.println("create time:"+stat.getCtime());
        System.out.println("cur time:"+stat.getMtime());
        System.out.println("子节点版本号:"+stat.getCversion());
        System.out.println("权限版本号:"+stat.getAversion());
        System.out.println("临时节点版本号:"+stat.getEphemeralOwner());
        System.out.println("数据长度:"+stat.getDataLength());
        System.out.println("子节点的数量:"+stat.getNumChildren());





    }

}
