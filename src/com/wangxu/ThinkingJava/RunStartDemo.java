package com.wangxu.ThinkingJava;

/**
 * 调用run方法，当前线程直接运行run方法，不会新开一个线程
 */
public class RunStartDemo {
    public static void main(String[] args) {
        RunStartDemo demo = new RunStartDemo();
        System.out.println(Thread.currentThread().getName() + "--> main");
        Thread thread = new Thread(demo.new RunnableImple(), "thread1");
//        thread.run();
        thread.start();
    }

    private class RunnableImple implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--> run");
        }
    }
}
