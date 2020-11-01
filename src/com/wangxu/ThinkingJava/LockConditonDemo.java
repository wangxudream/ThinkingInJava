package com.wangxu.ThinkingJava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于Lock实现阻塞队列
 */
public class LockConditonDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        BlockList bk = new BlockList(10);
        Pro pro1 = new Pro(bk, 10000, "pro1");
        Pro pro2 = new Pro(bk, 10000, "pro2");
        Con con1 = new Con(bk, "Con1");
        Con con2 = new Con(bk, "Con2");
        Check check = new Check(bk);
        service.submit(pro1);
        service.submit(pro2);
        service.submit(con1);
        service.submit(con2);
        service.submit(check);
    }

    private static class BlockList {
        private final ReentrantLock lock;
        private final Object[] items;
        private final Condition notFull;
        private final Condition notEmpty;
        private int count;
        private int takeIndex;
        private int putIndex;

        public BlockList(int capacity) {
            this(capacity, false);
        }

        public BlockList(int capacity, boolean fair) {
            if (capacity <= 0)
                throw new IllegalArgumentException();
            this.lock = new ReentrantLock(fair);
            this.items = new Object[capacity];
            notEmpty = lock.newCondition();
            notFull = lock.newCondition();
        }

        private void checkNotNull(Object obj) {
            if (obj == null)
                throw new NullPointerException();
        }


        public void put(Object obj) throws InterruptedException {
            checkNotNull(obj);
            lock.lockInterruptibly();
            try {
                //数组是满的，生产者等待
                while (count == items.length) {
                    notEmpty.await();
                }
                items[putIndex] = obj;
                if (++putIndex == items.length) {
                    putIndex = 0;
                }
                count++;
                notFull.signal();
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lockInterruptibly();
            try {
                while (count == 0) {
                    notFull.await();
                }
                Object obj = items[takeIndex];
                items[takeIndex] = null;
                if (++takeIndex == items.length) {
                    takeIndex = 0;
                }
                count--;
                notEmpty.signal();
                return obj;
            } finally {
                lock.unlock();
            }
        }

        public int getSize() throws InterruptedException {
            lock.lockInterruptibly();
            try {
                return count;
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Pro implements Callable {
        private BlockList blockList;
        private int times;
        private String name;

        public Pro(BlockList blockList, int times, String name) {
            this.blockList = blockList;
            this.times = times;
            this.name = name;
        }


        @Override
        public Object call() throws Exception {
            for (int i = 0; i < times; i++) {
                blockList.put(i);
                System.out.println(name + "---->put" + i);
                Thread.sleep(300);
            }
            return "";
        }
    }

    private static class Con implements Callable {
        private BlockList blockList;
        private String name;

        public Con(BlockList blockList, String name) {
            this.blockList = blockList;
            this.name = name;
        }


        @Override
        public Object call() throws Exception {
            while (true) {
                Object obj = blockList.take();
                if (obj == null) {
                    throw new RuntimeException("结果为null");
                }
                System.out.println(name + "---->get" + obj);
                Thread.sleep(300);
            }
        }
    }

    private static class Check implements Callable {
        private BlockList blockList;

        public Check(BlockList blockList) {
            this.blockList = blockList;
        }


        @Override
        public Object call() throws Exception {
            while (true) {
                int size = blockList.getSize();
                System.out.println("count---->" + size);
                if (size < 0 || size > 10) {
                    throw new RuntimeException("数量错误");
                }
                Thread.sleep(500);
            }
        }
    }
}
