package com.wangxu.ThinkingJava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Future的使用
 */
public class ExecutorsDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Boolean> future = pool.submit(new Task());
            futures.add(future);
        }
        for (Future<Boolean> future : futures) {
            //get 方法阻塞等待结果
//            System.out.println(future.get();
            System.out.println(future.get(1000, TimeUnit.MILLISECONDS));
        }
    }

    private static class Task implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            Thread.sleep(3000);
            long time = new Date().getTime();
            if (time % 2 == 0) {
                return true;
            }
            return false;
        }
    }
}

