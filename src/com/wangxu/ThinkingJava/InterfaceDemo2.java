package com.wangxu.ThinkingJava;

import java.util.concurrent.atomic.AtomicInteger;

public interface InterfaceDemo2 {
    AtomicInteger size = new AtomicInteger();

    static void staticMethod() {
        System.out.println("staticMethod");
    }

    /**
     * 子类可重写该方法
     */
    default void defaultMethod() {
        System.out.println("sup defaultMethod");
    }

    void normalMethod();
}

