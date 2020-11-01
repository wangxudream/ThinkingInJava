package com.wangxu.ThinkingJava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Runnable接口也可以通过传入参数的形式来实现返回值
 */
public class ExecutorsDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        List<Future> callFutures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Boolean> future = pool.submit(new CallTask());
            callFutures.add(future);
        }

        List<Future> runFutures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Result result = new Result();
            Future<Result> future = pool.submit(new RunTask(result), result);
            runFutures.add(future);
        }

        for (Future<Boolean> future : callFutures) {
            System.out.println("callFutures:" + future.get());
        }

        for (Future<Boolean> future : runFutures) {
            System.out.println("runFutures:" + future.get());
        }
    }

    private static class CallTask implements Callable<Boolean> {
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

    private static class RunTask implements Runnable {
        private ExecutorsDemo3.Result result;

        public RunTask(ExecutorsDemo3.Result result) {
            this.result = result;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long time = new Date().getTime();
            if (time % 2 == 0) {
                result.setCode(200);
                result.setMsg("success");
            } else {
                result.setCode(404);
                result.setMsg("failed");
            }
        }
    }

    private static class Result {
        private Integer code;
        private String msg;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }
}
