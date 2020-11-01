package com.wangxu.ThinkingJava;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunableDemo implements Runnable {
    @Override
    public void run() {
        Date date = new Date();
        if (date.getTime() % 2 == 1) {
            System.out.println("运行异常");
            throw new NullPointerException("运行异常");
        } else {
            System.out.println("运行正常");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(new RunableDemo());
    }
}
