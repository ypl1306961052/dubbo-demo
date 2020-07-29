package com.ypl.zk;
/*
作者：yangp
创建时间：2020/7/29-17:16-2020
*/


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: ZkLock
 * @Package com.ypl.zk
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/29 17:16
 */


public class ZkLock implements Lock {

    private ZooKeeper zooKeeper;
    private String lockPath;
    private byte[] nodeData = new byte[0];
    /**
      当前子节点 path
     */
    private String cpath;
    private List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;

    /**
     * 思路: 对一个节点及
     */
    /**
     * @param ip             地址
     * @param lockPath       zk的节点地址
     * @param sessionTimeout 会话超时时间 毫秒
     */
    public ZkLock(String ip, String lockPath, int sessionTimeout) {
        this.lockPath = lockPath;
        try {
            this.zooKeeper = new ZooKeeper(ip, sessionTimeout, this.watcher);
        } catch (IOException e) {
            throw new ZkLockException(e);
        }

    }

    private final Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent.getType());
            if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                System.out.println("链接zk成功");
            }else if(watchedEvent.getType()== Event.EventType.NodeDeleted){
                //监听到了上一个节点的数据 删除了
                //说明 自己的节点 获得锁
                System.out.println("节点删除了"+watchedEvent.getPath());
                synchronized (this){

                    notifyAll();
                    try {
                        zooKeeper.close();
                        System.out.println("关闭链接"+zooKeeper.getSessionId());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }else if(watchedEvent.getState()== Event.KeeperState.Disconnected){
                //检测节点数量为几个 如果没有 则删除父节点
//                System.out.println("关闭");
                try {
                    List<String> children = zooKeeper.getChildren(lockPath, false);
                    if(children.size()==0){
                        zooKeeper.delete(lockPath,-1);
                    }
                    System.out.println("关闭");
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    /**
     * 上锁
     */
    @Override
    public void lock() {
//首先判断 该节点在zk中是否有坑没有
        Stat stat = null;
        try {
            stat = zooKeeper.exists(lockPath, true);
            if (stat == null) {
                //坑位没有占领
                //创建坑位
                //如果抛出异常说明
                String path = zooKeeper.create(lockPath, nodeData, acl, CreateMode.PERSISTENT);
                System.out.println(path + "创建成功");
            }
            String cNode = lockPath + "/lock_";
            //创建自己的子节点 有序
            cpath = zooKeeper.create(cNode, nodeData, acl, CreateMode.EPHEMERAL_SEQUENTIAL);
            //获取所有子节点的数据 然后 排序 然后 判断 自己的子节点是否在一个 如果是第一名 则说明拿到了 拿到了锁 如果 不是第一名 则说明没有拿到 锁 然后去监听自己节点上一次的
            // 如果他消失（删除了） 说明该轮到自己去执行了
            List<String> children = zooKeeper.getChildren(lockPath, true);
            Collections.sort(children);
            int index = children.indexOf(cpath.substring(lockPath.length()+1));
            if (index == 0) {
                //说明获得锁了
                //继续执行
            } else {
                //监听自己位置的上一位
                String lastNodePath = children.get(index - 1);
                zooKeeper.exists(lockPath+"/"+lastNodePath, true);
                synchronized (watcher){
                    //代码暂停执行
                    //等待轮询到自己
                    watcher.wait();
                }
            }

        } catch (KeeperException | InterruptedException e) {
            //抛出异常
            lock();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * 解锁
     */
    @Override
    public void unlock() {
        try {
            zooKeeper.delete(cpath,-1);
            System.out.println(cpath+"删除数据");
//
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
            System.out.println("释放锁失败");
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        String path="/lock01";
        for (int i = 0; i < 2; i++) {
            Thread thread=new Thread(() -> {
                ZkLock zkLock=new ZkLock("127.0.0.1:2181",path,10000);
                System.out.println("上锁");
                zkLock.lock();
                try {

                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                zkLock.unlock();
                System.out.println("释放锁");
            });
            thread.start();
        }

        Thread.sleep(10000);
        System.out.println("程序退出");

    }
}
