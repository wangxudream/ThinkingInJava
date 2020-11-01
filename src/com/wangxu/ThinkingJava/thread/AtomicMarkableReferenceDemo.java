package com.wangxu.ThinkingJava.thread;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * 原子标记引用
 * 单只关注有没有改变时可以使用该
 */
public class AtomicMarkableReferenceDemo {
    public static void main(String[] args) {
        AtomicMarkableReference<String> mark = new AtomicMarkableReference<>("A", false);
        mark.set("B", true);
        if (mark.compareAndSet("B", "A", false, true)) {
            System.out.println("success");
        } else {
            System.out.println("false");
        }
    }
}
