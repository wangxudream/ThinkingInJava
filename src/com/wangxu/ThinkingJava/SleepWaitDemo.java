package com.wangxu.ThinkingJava;

/**
 * sleep不会释放锁对象
 */
public class SleepWaitDemo {
    public static void main(String[] args) {
        Object lock = new Object();
        Runnable task = () -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "->get lock");
                try {
                    System.out.println(Thread.currentThread().getName() + "->start sleep");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName() + "->stop sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(task, "thread1");
        Thread thread2 = new Thread(task, "thread2");
        thread1.start();
        thread2.start();
    }
}
