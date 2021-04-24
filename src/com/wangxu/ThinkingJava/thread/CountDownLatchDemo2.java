package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.*;

/**
 * @ClassName CountDownLatchDemo2
 * @Description: TODO
 * @Author kataer
 * @Date 2020/12/31 15:03
 * @Version V1.0
 **/
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch endLatch = new CountDownLatch(10);
        final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5,
                60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            poolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        startLatch.await();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    } finally {
                        endLatch.countDown();
                    }
                }
            });
        }
        long start = System.nanoTime();
        startLatch.countDown();
        endLatch.await();
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
