package com.wangxu.ThinkingJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Synchronized
 * 1、修饰实例方法，需要获取当前实例的锁
 * 2、修饰静态方法，获取当前类对象的锁
 * 3、修饰代码块，指定加锁对象
 * <p>
 * 测试null能不能作为锁对象
 */
public class SynchronizedDemo2 implements Runnable {
    private static Object lock = null;
    private static int count = 0;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            pool.submit(new SynchronizedDemo2());
        }
        pool.shutdown();

       while (!pool.isTerminated()){
           try {
               Thread.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

        System.out.println(count);
    }


    public void run() {
        synchronized (lock) {
            count++;
        }
    }
}
