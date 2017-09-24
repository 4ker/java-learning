package com.brianway.learning.java.base.generics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Demo {
    //准备一个哈希表，为每个线程准备数据
    private static Map<Thread,Integer> threadData = new HashMap<>();
    private static Set<Thread> threads = new HashSet<>();
    public static void main(String[] args) {
        for(int i=0;i<200;i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            Thread thread = Thread.currentThread();
                            int data = new Random().nextInt();
                            threadData.put(thread,data);
//                            System.out.println(thread+" put data："+data);
                            new A().get();
                            new B().get();
                        }
                    }).start();
        }
    }
    static class A{
        public void get(){
            Thread thread = null;
            try {
                int data = threadData.get(thread = Thread.currentThread());
//                System.out.println("A from "+Thread.currentThread()+" get data "+data);
            } catch (Exception e) {
                if (!threads.contains(thread)) {
                    System.err.println("the thread is: " + thread);
                } else {
                    System.err.println("ooooooooooooooooooops");
                }
            }
        }
    }

    static class B{
        public void get(){
            Thread thread = null;
            try {
                int data = threadData.get(thread = Thread.currentThread());
//                System.out.println("B from "+Thread.currentThread()+" get data "+data);
            } catch (Exception e) {
                if (!threads.contains(thread)) {
                    System.err.println("the thread is: " + thread);
                } else {
                    System.err.println("ooooooooooooooooooops");
                }
            }
        }
    }
}
