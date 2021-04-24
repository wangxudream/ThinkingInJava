package com.wangxu.ThinkingJava.thread;

/**
 * @ClassName ThreadJoin
 * @Description: TODO
 * @Author kataer
 * @Date 2020/12/25 12:08
 * @Version V1.0
 **/
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("A Task");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadA");
        threadA.start();
        threadA.join();
        System.out.println("After");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadA.join();
                    System.out.println("B Task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadB");

    }
}
