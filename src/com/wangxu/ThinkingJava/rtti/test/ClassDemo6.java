package com.wangxu.ThinkingJava.rtti.test;

import java.util.Random;

/**
 * 测试类初始化的惰性
 */
public class ClassDemo6 {
    class InnerTest1 {
        public void test() {
            System.out.println("test start");
            System.out.println("before use TestInit.STATIC_FINAL");
            System.out.println(TestInit.STATIC_FINAL);
            System.out.println("after use TestInit.STATIC_FINAL");
            System.out.println("before use TestInit.RANDOM");
            System.out.println(TestInit.RANDOM.nextInt());
            System.out.println("after use TestInit.RANDOM");
            System.out.println("test end");
        }
    }

    class InnerTest2 {
        public void test() {
            System.out.println("test start");
            System.out.println("before use TestInit.STATIC_FINAL");
            System.out.println(TestInit2.STATIC_FINAL);
            System.out.println("after use TestInit.STATIC_FINAL");
            System.out.println("before use staticFiled");
            System.out.println(TestInit2.staticFiled);
            System.out.println("after use staticFiled");
            System.out.println("test end");
        }
    }

    public static void main(String[] args) {
        ClassDemo6 demo6 = new ClassDemo6();
        InnerTest1 test1 = demo6.new InnerTest1();
        test1.test();
        System.out.println("------------------");
        InnerTest2 test2 = demo6.new InnerTest2();
        test2.test();
    }
}

class TestInit {
    public static final String STATIC_FINAL = "STATIC_FINAL";
    public static final Random RANDOM = new Random();

    public static String staticFiled = "staticFiled";

    static {
        System.out.println("静态初始化块");
    }
}

class TestInit2 {
    public static final String STATIC_FINAL = "STATIC_FINAL";
    public static final Random RANDOM = new Random();

    public static String staticFiled = "staticFiled";

    static {
        System.out.println("静态初始化块");
    }
}