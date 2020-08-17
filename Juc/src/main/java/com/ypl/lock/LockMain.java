package com.ypl.lock;
/*
作者：yangp
创建时间：2020/8/17-10:13-2020
*/


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: LockMain
 * @Package com.ypl.lock
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/8/17 10:13
 */


public class LockMain {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {

                reentrantLock.lock();
                try {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Integer sum = addSum(0, 100);
                    System.out.println("计算完成，计算的结果:" + sum);
                    condition.signalAll();
//                    Thread.sleep(1000);
                    System.out.println(" 查询当前线程保持此锁的次数:"+reentrantLock.getHoldCount());
                    System.out.println("返回等待获取次锁的线程线程数:"+reentrantLock.getQueueLength());
                    //// 返回一个 collection，它包含可能正等待获取此锁的线程。
                    System.out.println(reentrantLock.getWaitQueueLength(condition));
                    // 查询是否有些线程正在等待获取此锁。
                    System.out.println(reentrantLock.hasQueuedThreads());
                    System.out.println("当前线程{"+Thread.currentThread()+"}是否拥有该锁:"+reentrantLock.isHeldByCurrentThread());
                }finally {
                    reentrantLock.unlock();
                }

            }
        }).start();

        try {
            System.out.println("等待计算结果");
            reentrantLock.lock();
            try{
// 查询给定线程是否正在等待获取此锁。

                condition.await(1, TimeUnit.SECONDS);
                System.out.println(reentrantLock.hasQueuedThread(Thread.currentThread()));
                System.out.println("是否公平锁: "+reentrantLock.isFair());
            }finally {
                reentrantLock.unlock();
            }
            System.out.println("程序执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Integer addSum(int s, int e) {
        int sum = 0;
        for (int i = s; i <=e; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
