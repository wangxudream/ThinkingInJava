package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试指令的重排序
 * 2       count0
 * 9926997 count1
 * 73001   count2
 */
public class OrderDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 10000000; i++) {
            Demo demo = new Demo();
            Demo.Task1 task1 = demo.new Task1();
            Demo.Task2 task2 = demo.new Task2();
            pool.submit(task1);
            pool.submit(task2);
        }
        pool.shutdown();
        while (true) {
            if (pool.isTerminated()) {
                System.out.println(Demo.count0);
                System.out.println(Demo.count1);
                System.out.println(Demo.count2);
                break;
            }
        }
    }


    private static class Demo {
        private boolean flag = false;
        private volatile int num = 0;
        private static AtomicInteger count0 = new AtomicInteger();
        private static AtomicInteger count1 = new AtomicInteger();
        private static AtomicInteger count2 = new AtomicInteger();

        private class Task1 implements Runnable {

            @Override
            public void run() {
                if (flag) {
                    if (num == 0) {
                        //属于重排序的情况
                        count0.getAndIncrement();
                    } else {
                        count2.getAndIncrement();
                    }
                } else {
                    count1.getAndIncrement();
                }
            }
        }

        private class Task2 implements Runnable {

            @Override
            public void run() {
                //出现了指令重排序，对该变量加上violate能避免指令重排序
                num = 2;
                flag = true;
            }
        }
    }
}
