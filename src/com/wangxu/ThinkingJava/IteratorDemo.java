package com.wangxu.ThinkingJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName IteratorDemo
 * @Description: TODO
 * @Author kataer
 * @Date 2020/11/29 21:15
 * @Version V1.0
 **/
public class IteratorDemo {
    public static void main(String[] args) throws InterruptedException {
        test1();
//        test2();
    }

    public static void test1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                latch.countDown();
                integerList.add(100);
            }
        });
        boolean flag = true;

//        for (int i = 0; i < integerList.size(); i++) {
//            System.out.println("InFor size:" + integerList.size());
//            System.out.println("Element:" + integerList.get(i));
//            if (flag) {
//                //先进入循环再修改数据
//                thread.start();
//                flag = false;
//            }
//            latch.await();
//        }
        //ConcurrentModificationException
        for (Integer integer : integerList) {
            System.out.println("InFor size:" + integerList.size());
            System.out.println("Element:" + integer);
            if (flag) {
                //先进入循环再修改数据
                thread.start();
                flag = false;
            }
            latch.await();
        }

        System.out.println("integerList size:" + integerList.size());

        for (Integer integer : integerList) {
            System.out.println(integer);
            latch.await();
        }
    }


    public static void test2() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.add(4);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                latch.countDown();
                //Object[] newElements = Arrays.copyOf(elements, len + 1);
                copyOnWriteArrayList.add(100);
            }
        });

        boolean flag = true;
        for (Integer integer : copyOnWriteArrayList) {
            System.out.println("InFor size:" + copyOnWriteArrayList.size());
            System.out.println("Element:" + integer);
            if (flag) {
                thread.start();
                flag = false;
            }
            latch.await();
//            copyOnWriteArrayList.add(200);
        }

        System.out.println("AfterFor size:" + copyOnWriteArrayList.size());

        for (Integer integer : copyOnWriteArrayList) {
            System.out.println("Element:" + integer);
            latch.await();
        }
    }
}
