package com.wangxu.ThinkingJava;

import java.util.concurrent.*;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {


    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void terminated() {
        System.out.println("TIDYING");
    }

    public static void main(String[] args) {
//        (ExecutorService)MyThreadPoolExecutor pool = Executors.newSingleThreadExecutor();
    }
}
