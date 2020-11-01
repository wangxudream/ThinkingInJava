package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.*;

/**
 * CountDownLatch 倒计时锁，用于线程间的协助
 * 测试线程调度类
 * MILLISECONDS 毫秒
 * MICROSECONDS 微秒
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(11);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        pool.submit(new Task2(countDownLatch));
        for (int i = 0; i < 10; i++) {
            pool.submit(new Task1(countDownLatch));
        }
        pool.shutdown();
        while (true) {
            if (pool.isTerminated()) {
                break;
            }
        }

    }
    private static class Task1 implements Runnable {
        private CountDownLatch countDownLatch;

        public Task1(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Task2 implements Runnable {
        private CountDownLatch countDownLatch;

        public Task2(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("等待发射");
                countDownLatch.await();//阻塞等待，直到countdown减为0
                System.out.println("点火");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

