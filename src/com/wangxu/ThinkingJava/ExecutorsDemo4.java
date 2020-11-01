package com.wangxu.ThinkingJava;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * submit和excute的区别
 * Future<?> submit(Runnable task);  ExecutorService 的方法，有返回值，可以捕获异常
 * void execute(Runnable command); Executor的方法
 */
public class ExecutorsDemo4 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        try {
            pool.execute(() -> {
                System.out.println(1 / 0);
            });
//            Future<String> future = pool.submit(() -> {
//                System.out.println(1 / 0);
//                return "Test";
//            });
//            future.get();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("抓到异常 " + e.getMessage());
        }
    }


}
