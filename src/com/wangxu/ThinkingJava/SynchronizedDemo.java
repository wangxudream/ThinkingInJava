package com.wangxu.ThinkingJava;

/**
 * 由于flag++;的操作不具有原子性，存在线程安全问题
 * 输出的结果不是刚好为20000
 */
public class SynchronizedDemo implements Runnable {
    public static int flag = 0;

    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            flag++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo task = new SynchronizedDemo();
        Thread thread1 = new Thread(task, "thread1");
        Thread thread2 = new Thread(task, "thread1");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(flag);
    }
}

