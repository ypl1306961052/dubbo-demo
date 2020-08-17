package com.ypl.juc.qe;
/*
作者：yangp
创建时间：2020/8/17-11:38-2020
*/


import cn.hutool.core.util.RandomUtil;
import com.ypl.juc.qe.PriorityBlockingQueueMain.Person;
import javafx.concurrent.Task;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.Selector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: SynchronousQueueMain
 * @Package com.ypl.juc.qe
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/8/17 11:38
 */


public class SynchronousQueueMain {
    /**
     * 消费者
     */
    static class ConsumerTask implements Runnable {
        private SynchronousQueue<Person> personSynchronousQueue;

        public ConsumerTask(SynchronousQueue<Person> personSynchronousQueue) {
            this.personSynchronousQueue = personSynchronousQueue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Person take = personSynchronousQueue.take();
                    System.out.println("取出数据为:" + take);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class producesTask implements Runnable {
        private SynchronousQueue<Person> personSynchronousQueue;

        public producesTask(SynchronousQueue<Person> personSynchronousQueue) {
            this.personSynchronousQueue = personSynchronousQueue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Person person = new Person(RandomUtil.randomInt(0, 100), "ypl");
                    personSynchronousQueue.put(person);
                    System.out.println(Thread.currentThread().getName()+"生产了对象:" + person);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronousQueue<Person> people = new SynchronousQueue<>(true);
        ConsumerTask consumerTask = new ConsumerTask(people);
        new Thread(consumerTask).start();
        //生产者
        producesTask producesTask = new producesTask(people);
        new Thread(producesTask,"生产者1").start();
        producesTask producesTask1=new producesTask(people);
        new Thread(producesTask1,"生产者2").start();
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Channel channel= Channels.newChannel(new ByteArrayInputStream("ypl".getBytes()));
            Selector selector=Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
