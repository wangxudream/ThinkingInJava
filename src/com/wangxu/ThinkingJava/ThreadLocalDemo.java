package com.wangxu.ThinkingJava;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal = new ThreadLocalDemo.myThreadLocal(0);
        ThreadLocal<String> threadLocal2 = new ThreadLocalDemo.myThreadLocal("Test");

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadLocal.set(threadLocal.get() + 1);
                threadLocal2.set(threadLocal2.get() + i);
                System.out.println("Thread1:" + threadLocal.get());
                System.out.println("Thread1:" + threadLocal2.get());
            }
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadLocal.set(threadLocal.get() + 1);
                threadLocal2.set(threadLocal2.get() + i);
                System.out.println("Thread2:" + threadLocal.get());
                System.out.println("Thread2:" + threadLocal2.get());
            }
        }, "Thread2");


        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadLocal.set(threadLocal.get() + 1);
                threadLocal2.set(threadLocal2.get() + i);
                System.out.println("Thread3:" + threadLocal.get());
                System.out.println("Thread3:" + threadLocal2.get());
            }
        }, "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(3000);
        System.out.println("main:" + threadLocal.get());
        System.out.println("main:" + threadLocal2.get());
        System.out.println("threadLocal:" + threadLocal.get());
        System.out.println("threadLocal2:" + threadLocal2.get());

    }

    private static class myThreadLocal extends ThreadLocal {
        private Object object;

        public myThreadLocal(Object object) {
            this.object = object;
        }

        @Override
        protected Object initialValue() {
            return this.object;
        }
    }
}
