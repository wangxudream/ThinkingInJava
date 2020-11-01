package com.wangxu.ThinkingJava;

public class CountDemo {
    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            for (int i = 1; i <= 1000; i++) {
                new Sheep();
            }
        };

        Runnable runnable2 = () -> {
            for (int i = 1; i <= 1000; i++) {
                new Sheep();
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}


class Sheep {
    public static int count = 0;
    public int id = count++;

    public Sheep() {
        System.out.println("id:" + id);
    }
}