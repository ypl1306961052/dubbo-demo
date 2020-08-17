package com.ypl.lock;
/*
作者：yangp
创建时间：2020/8/17-10:45-2020
*/


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: SemaphoreMain
 * @Package com.ypl.lock
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/8/17 10:45
 */


public class SemaphoreMain {
    private Semaphore semaphore = new Semaphore(2,true);

    private int addSum(int num) {
        int sum = 0;
        try {
            //获取许可
            semaphore.acquire();
            //执行
            System.out.println("Accessing: " + num);
            System.out.println("等待队列为:"+semaphore.getQueueLength());
            System.out.println("信号许可还剩:"+semaphore.availablePermits());
            Thread.sleep(new Random().nextInt(5000)); // 模拟随机执行时长
            //释放
            semaphore.release();
            System.out.println("Release..." + num);

        } catch (InterruptedException e) {
            e.printStackTrace();
            sum = -1;
        }
        return sum;
    }

    public static void main(String[] args) {
        SemaphoreMain semaphoreMain = new SemaphoreMain();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            int finalI = i;
            executorService.submit(()->{
                semaphoreMain.addSum(finalI);
            });
        }
        executorService.shutdown();

    }
}
