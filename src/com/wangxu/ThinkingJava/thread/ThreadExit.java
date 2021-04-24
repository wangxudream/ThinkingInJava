package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ThreadExit
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/4 23:04
 * @Version V1.0
 **/
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(3);
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.countDown();
                    while (true) {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread0");

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.countDown();
                    while (true) {
                        Thread.sleep(20000);
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(1 / 0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Thread2");

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                latch.countDown();
                while (true) {
                    try {
                        Thread.sleep(30000);
                        System.out.println(Thread.currentThread().getName());
                          System.out.println(1 / 0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("finally");
                    }
                }
            }
        }, "Thread3");
        thread1.start();
        thread2.start();
        thread3.start();
        latch.await();
    }
}
