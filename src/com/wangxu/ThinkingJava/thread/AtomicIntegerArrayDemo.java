package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子数组
 * 数组里的每一个元素的操作都是原子的
 */
public class AtomicIntegerArrayDemo {
    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();
    }

    private static void test1() throws InterruptedException {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    for (int k = 0; k < 10; k++) {
                        array[k]++;
                    }
                }
            }).start();
        }

        Thread.sleep(10000);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void test2() throws InterruptedException {
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    for (int k = 0; k < 10; k++) {
                        array.getAndIncrement(k);
                    }
                }
            }).start();
        }

        Thread.sleep(10000);
        System.out.println(array);
    }

}
