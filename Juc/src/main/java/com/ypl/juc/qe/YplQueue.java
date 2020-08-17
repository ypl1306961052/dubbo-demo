package com.ypl.juc.qe;
/*
作者：yangp
创建时间：2020/8/17-11:15-2020
*/


import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.util.ArrayUtil;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: YplDuqeue
 * @Package com.ypl.juc.qe
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/8/17 11:15
 */


public class YplQueue<T> extends AbstractQueue<T> {
    private Object[] queue;
    private int count;
    private int initialCapacity;
    private int curIndex;

    public YplQueue(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.queue = new Object[this.initialCapacity];
    }

    public YplQueue() {
        this(10);
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr(toArray());
    }

    @Override
    public Object[] toArray() {
        return queue;
    }

    final class Itr implements Iterator<T> {
        private final Object[] objects;
        private int curIndex = 0;

        public Itr(Object[] objects) {
            this.objects = objects;
        }

        @Override
        public boolean hasNext() {
            return curIndex < this.objects.length;
        }

        @Override
        public T next() {
            if (curIndex > objects.length) {
                curIndex = objects.length;
            }
            return (T) this.objects[curIndex++];
        }
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean offer(T t) {
        if(curIndex>queue.length){
            return false;
        }
        queue[this.curIndex++]=t;
        return true;
    }

    @Override
    public T poll() {
        if(queue.length==0){
            return null;
        }
        Object o = queue[0];
        //



        return (T) o;
    }
    private Object[] copy(int start,int end){
//        for (int i = 0; i < queue.length; i++) {
//
//        }
//        return
        return null;
    }

    @Override
    public T peek() {

        return null;
    }
}
