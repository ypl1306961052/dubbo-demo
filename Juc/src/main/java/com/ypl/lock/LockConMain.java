package com.ypl.lock;
/*
作者：yangp
创建时间：2020/8/17-10:24-2020
*/


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: LockConMain
 * @Package com.ypl.lock
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/8/17 10:24
 */


public class LockConMain {

    private static Lock lock = new ReentrantLock();
    private static Condition subCondition = lock.newCondition();
    private static volatile boolean subFlag = false;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    lock.lock();
                    try {
                        if (subFlag) {
                            subCondition.await();
                        }
                        for (int j = 0; j < 2; j++) {
                            System.out.println(Thread.currentThread().getName()
                                    + ":i=" + i + ",j=" + j);
                        }
                        subFlag = true;
                        subCondition.signal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }

        });
        threadPool.shutdown();
        for (int i = 0; i < 5; i++) {
            lock.lock();
            try {
                if (!subFlag) {
                    subCondition.await();
                }
                for (int j = 0; j < 4; j++) {
                    System.out.println(Thread.currentThread().getName() + ":i="
                            + i + ",j=" + j);
                }
                subFlag = false;
                subCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
