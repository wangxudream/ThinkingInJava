package com.wangxu.ThinkingJava.InterfaceDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class InterfaceDemo {
    public static void main(String[] args) {

        Interface i1 = () -> {
            System.out.println("i1 sub normalMethod");
        };

        Interface i2 = new Interface() {
            @Override
            public void normalMethod() {
                System.out.println("i2 sub normalMethod");
            }

            @Override
            public void defaultMethod() {
                System.out.println("i2 sub defaultMethod");
            }
        };

        Interface.size.getAndIncrement();

        Interface.staticMethod();

        i1.defaultMethod();

        i2.defaultMethod();
    }
}

interface Interface {
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
