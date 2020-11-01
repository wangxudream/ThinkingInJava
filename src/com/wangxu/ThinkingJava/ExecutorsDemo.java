package com.wangxu.ThinkingJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、创建线程池的方法
 * 利用Executors的静态方法
 * 2、线程池的状态
 * running
 * shutdown
 * stop
 * tidying
 * TERMINATED
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        System.out.println(pool.getClass());
        for (int i = 0; i < 10; i++) {
            pool.submit(new Task());
        }
        System.out.println("pool shutdown");
        pool.shutdown();
//        pool.shutdownNow();
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--> start sleep");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--> stop sleep");
        }
    }
}
