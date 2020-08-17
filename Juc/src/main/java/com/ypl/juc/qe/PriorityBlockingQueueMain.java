package com.ypl.juc.qe;
/*
作者：yangp
创建时间：2020/8/17-10:02-2020
*/


import java.net.SocketTimeoutException;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: PriorityBlockingQueueMain
 * @Package com.ypl.juc.qe
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/8/17 10:02
 */


public class PriorityBlockingQueueMain {
    /**
     * 权限队列
     */
    private static PriorityBlockingQueue<Person> people=new PriorityBlockingQueue<>();

    public static void main(String[] args) {

        addPerson(3,"ypl");
        addPerson(2,"ypl");
        addPerson(1,"ypl");

        System.out.println(poll());
    }
    private static Person remove(){
        //弹出队列头部的对象
        return people.remove();
    }

    private static Person poll(){
        //弹出队列头部的对象
        return people.poll();
    }


    private static void addPerson(int personId,String name) {
        Person person=new Person(personId,name);
        people.add(person);
        System.out.println(people);
    }

    public static class Person implements Comparable<Person> {
        private int personId;
        private String name;

        public Person(int personId, String name) {
            this.personId = personId;
            this.name = name;
        }

        public int getPersonId() {
            return personId;
        }

        public void setPersonId(int personId) {
            this.personId = personId;
        }


        @Override
        public int compareTo(Person o) {
            if(this.getPersonId()>o.getPersonId()){
                return 1;
            }else if(this.getPersonId()<o.getPersonId()){
                return -1;

            }else {
                return 0;
            }



        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("personId=").append(personId);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
