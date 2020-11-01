package com.wangxu.ThinkingJava;

import java.util.Date;
import java.util.concurrent.*;

public class CallableDemo implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        Date date = new Date();
        if (date.getTime() % 2 == 1) {
            return true;
        } else {
            throw new RuntimeException("运行异常");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Boolean> future = service.submit(new CallableDemo());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }catch (RuntimeException e){
            System.out.println(e);
        }
    }
}
