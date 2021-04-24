package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreDemo
 * @Description: 信号量
 * @Author kataer
 * @Date 2020/12/31 15:34
 * @Version V1.0
 **/
public class SemaphoreDemo {
    final static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            Thread thread = new Thread(new MyTask(semaphore));
            thread.start();
        }

    }

    static class MyTask implements Runnable {
        private Semaphore semaphore;

        public MyTask(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            boolean acquire = false;
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + ">>>>acquire");
                acquire = true;
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (acquire) {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + ">>>>release");
                }
            }
        }
    }


}
