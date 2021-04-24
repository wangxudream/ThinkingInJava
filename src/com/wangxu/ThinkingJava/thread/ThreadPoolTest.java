package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolTest
 * @Description: 测试线程池中线程的创建机制（利用Java VisualVM查看线程）
 * @Author kataer
 * @Date 2020/12/25 15:58
 * @Version V1.0
 **/
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue(10), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("任务被拒绝了" + r.toString());
            }
        });

        Thread.sleep(10000);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(5000);
            pool.submit(new MyTask(i));
            System.out.println("任务提交:" + i);
        }
        Thread.sleep(100000);
    }

    public static class MyTask implements Runnable {
        private int order;

        public MyTask(int order) {
            this.order = order;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ">>>>执行任务");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "MyTask{" +
                    "order=" + order +
                    '}';
        }
    }
}
