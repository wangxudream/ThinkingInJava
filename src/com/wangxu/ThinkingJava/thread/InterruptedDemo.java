package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName InterruptedDemo
 * @Description:
 * @Author kataer
 * @Date 2020/12/31 13:58
 * @Version V1.0
 **/
public class InterruptedDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                latch.countDown();
                try {
                    for (; ; ) {
                        System.out.println("State:" + Thread.currentThread().isInterrupted());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("State In Catch:" + Thread.currentThread().isInterrupted());
                    //将打断标识设置为true，方便后续判断
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println("State In finally:" + Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        latch.await();
        Thread.sleep(1000);
        thread.interrupt();
        if (thread.isInterrupted()) {
            System.out.println("任务线程被中断");
        }
    }
}
