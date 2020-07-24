package com.ypl.zk;
/*
作者：yangp
创建时间：2020/7/23-14:27-2020
*/


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: ZookeeperTestGetChildrenNodeSync02
 * @Package com.ypl.zk
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/23 14:27
 */


public class ZookeeperTestGetChildrenNodeSync02 implements Watcher {
private ZooKeeper zooKeeper;

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }
private static final String nodeName="/test02/07";
    private final Stat stat=new Stat();
    public static void main(String[] args) throws KeeperException, InterruptedException {
        ZookeeperTestGetChildrenNodeSync02 sync02=new ZookeeperTestGetChildrenNodeSync02();
        ZooKeeper zooKeeper = ZookeeperUtil.createZooKeeper(sync02);
        sync02.setZooKeeper(zooKeeper);
        Stat exists = zooKeeper.exists(nodeName, true);
        if(exists.getCzxid()<0){

        }
        zooKeeper.create(nodeName,"hhh".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //监听数据
        System.out.println(zooKeeper.getChildren(nodeName, true));
        System.out.println("创建节点");
        zooKeeper.setData(nodeName,"eee".getBytes(),-1);
        zooKeeper.setData(nodeName,"yyyy".getBytes(),-1);

    }
    @Override
    public void process(WatchedEvent watchedEvent) {

        System.out.println(Thread.currentThread().getName());
        if(watchedEvent.getType()== Event.EventType.NodeDataChanged){
            //创建数据
            try {
                System.out.println(Arrays.toString(this.zooKeeper.getData(nodeName, true, stat)));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
