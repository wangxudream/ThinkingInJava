//package com.wangxu.ThinkingJava;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * 利用Lock的Condtion实现交替打印红绿灯
// * 1、使用Lock实现串行
// * 2、利用条件判断是否执行
// */
//public class RGYLight {
//    public static void main(String[] args) {
//
//
//        Thread red = new Thread(() -> {
//            while (true) {
//                while (flag == 1) {
//                    try {
//                        lock.lockInterruptibly();
//                        System.out.println("--->红灯亮");
//                        flag = 2;
//                        b.signal();//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        if (lock.isHeldByCurrentThread()) {
//                            lock.unlock();
//                        }
//                    }
//                }
//                try {
//                    a.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//        Thread green = new Thread(() -> {
//            while (true) {
//                try {
//                    lock.lockInterruptibly();
//                    System.out.println("--->绿灯亮");
//                    c.signal();
//                    b.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    if (lock.isHeldByCurrentThread()) {
//                        lock.unlock();
//                    }
//                }
//            }
//        });
//
//
//        Thread yellow = new Thread(() -> {
//            while (true) {
//                try {
//                    lock.lockInterruptibly();
//                    System.out.println("--->黄灯亮");
//                    a.signal();
//                    c.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    if (lock.isHeldByCurrentThread()) {
//                        lock.unlock();
//                    }
//                }
//            }
//        });
//
//        red.start();
//        green.start();
//        yellow.start();
//    }
//
//    private static class Light {
//        final ReentrantLock lock = new ReentrantLock();
//        final Condition a = lock.newCondition();
//        final Condition b = lock.newCondition();
//        final Condition c = lock.newCondition();
//        volatile int flag = 1;
//
//        private void light(int id) {
//            while (flag != id) {
//
//            }
//        }
//
//    }
//}
