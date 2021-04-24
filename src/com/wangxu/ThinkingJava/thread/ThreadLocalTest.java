package com.wangxu.ThinkingJava.thread;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * @ClassName ThreadLocalTest
 * @Description: TODO
 * @Author kataer
 * @Date 2020/12/25 15:06
 * @Version V1.0
 **/
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        ThreadLocal<ArrayList<String>> threadLocal = ThreadLocal.withInitial(() -> strings);

        Thread thread = new Thread(() -> {
            try {
                System.out.println(threadLocal.get());
                Thread.sleep(5000);
                System.out.println(threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ThreadA");
        thread.start();
        Thread.sleep(1000);
        threadLocal.get().add("B");
    }
}
