package com.wangxu.ThinkingJava.thread;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用(无法感知ABA问题)
 * BigDecimal 是一个不可变类，每个操作都会返回新的对象
 * BigDecimal 是一个线程不安全的对象
 */
public class AtomicReferDemo {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        AtomicReferDemo atomicReferDemo = new AtomicReferDemo();
        AccountImpl1 imple1 = atomicReferDemo.new AccountImpl1(new BigDecimal("1000"));
        for (int i = 0; i < 100; i++) {
            pool.submit(() -> {
                imple1.draw(BigDecimal.TEN);
            });
        }
        pool.shutdown();
        while (true) {
            if (pool.isTerminated()) {
                System.out.println(imple1.get());
                break;
            }
        }
    }

    public static void test2() {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        AtomicReferDemo atomicReferDemo = new AtomicReferDemo();
        AccountImpl2 imple2 = atomicReferDemo.new AccountImpl2(new BigDecimal("1000"));
        for (int i = 0; i < 100; i++) {
            pool.submit(() -> {
                imple2.draw(BigDecimal.TEN);
            });
        }
        pool.shutdown();
        while (true) {
            if (pool.isTerminated()) {
                System.out.println(imple2.get());
                break;
            }
        }
    }

    /**
     * BigDecimal是一个线程非安全的对象
     */
    private class AccountImpl1 implements Account {
        private BigDecimal bigDecimal;

        public AccountImpl1(BigDecimal bigDecimal) {
            this.bigDecimal = bigDecimal;
        }

        @Override
        public BigDecimal get() {
            return bigDecimal;
        }

        @Override
        public void draw(BigDecimal amount) {
            //每个操作返回新的对象
            bigDecimal = bigDecimal.subtract(amount);
        }
    }

    /**
     * 利用AtomicReference封装BigDecimal
     */
    private class AccountImpl2 implements Account {
        private AtomicReference<BigDecimal> atomicReference;

        public AccountImpl2(BigDecimal bigDecimal) {
            this.atomicReference = new AtomicReference<>(bigDecimal);
        }

        @Override
        public BigDecimal get() {
            return atomicReference.get();
        }

        @Override
        public void draw(BigDecimal amount) {
            //自旋+cas
            while (true) {
                BigDecimal expect = atomicReference.get();
                BigDecimal update = atomicReference.get().subtract(amount);
                //其实质是指调用Unsafe类的compareAndSwapObject来实现
                if (atomicReference.compareAndSet(expect, update)) {
                    break;
                }
            }
        }
    }

    private interface Account {
        BigDecimal get();

        void draw(BigDecimal bigDecimal);
    }
}
