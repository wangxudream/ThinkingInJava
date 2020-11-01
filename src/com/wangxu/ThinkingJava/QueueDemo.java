package com.wangxu.ThinkingJava;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 演示队列的操作
 */
public class QueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque(3);
        try {
            queue.put("First");
            queue.put("Second");
            queue.put("Third");
            queue.put("Fourth");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
