package com.wangxu.ThinkingJava;

public class SleepWaitDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Runnable task1 = () -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "->get lock");
                try {
                    System.out.println(Thread.currentThread().getName() + "->start wait");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "->stop wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
//
//        Runnable task2 = () -> {
//            synchronized (lock) {
//                System.out.println(Thread.currentThread().getName() + "->get lock");
//                System.out.println(Thread.currentThread().getName() + "->start notify");
//                lock.notify();
//                System.out.println(Thread.currentThread().getName() + "->stop notify");
//            }
//        };
        Thread thread1 = new Thread(task1, "thread1");
        Thread thread2 = new Thread(task1, "thread2");
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        System.out.println("thread1 state --->"+thread1.isAlive());
        System.out.println("thread2 state --->"+thread2.isAlive());

    }
}
