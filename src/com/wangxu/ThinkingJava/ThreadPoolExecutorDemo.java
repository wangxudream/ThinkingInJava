package com.wangxu.ThinkingJava;


import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), new MyThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.submit(new MyTask("task-" + i));
        }
    }

    private static class MyThreadFactory implements ThreadFactory {
        int i = 1;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "myThread" + (i++));
        }
    }

    private static class MyTask implements Runnable {
        private String taskName;

        public MyTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(60000);
                System.out.println(Thread.currentThread().getName() + ">>>>" + taskName + ":finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "MyTask{" +
                    "taskName='" + taskName + '\'' +
                    '}';
        }
    }


}
