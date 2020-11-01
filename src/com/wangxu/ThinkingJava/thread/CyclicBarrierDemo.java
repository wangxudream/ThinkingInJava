package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 和countdownlatch类似，不过可以复用
 * 注意：线程数要和计数一致
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("执行了三次任务");
        });
        for (int i = 0; i < 10; i++) {
            pool.submit(()->{
                try {
                    cyclicBarrier.await();//次数减1
                    System.out.println("Task1执行");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            pool.submit(()->{
                try {
                    cyclicBarrier.await();//次数减1
                    System.out.println("Task2执行");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            pool.submit(()->{
                try {
                    cyclicBarrier.await();//次数减1
                    System.out.println("Task3执行");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
    }
}
