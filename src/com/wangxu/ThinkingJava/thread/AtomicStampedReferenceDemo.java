package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 原子引用加上时间戳
 * 使用版本号来解决ABA问题，可感知ABA问题
 */
public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        AtomicReference<String> atomicReference = new AtomicReference("A");
        new Thread(() -> {
            atomicReference.set("B");
            atomicReference.set("A");
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                if (atomicReference.compareAndSet("A", "B")) {
                    System.out.println("change A -->B success");
                } else {
                    System.out.println("change A -->B false");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void test2() {
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference("A", 0);
        int initStamp = atomicStampedReference.getStamp();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            //每次设置值改变版本号，不改变的话也是无法感知ABA问题
            atomicStampedReference.set("B", stamp + 1);
            atomicStampedReference.set("A", stamp + 2);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //将A变成B假如版本号正确
        if (atomicStampedReference.compareAndSet("A", "B", initStamp, initStamp + 1)) {
            System.out.println("change A -->B success");
        } else {
            System.out.println("change A -->B false");
        }
    }

}
