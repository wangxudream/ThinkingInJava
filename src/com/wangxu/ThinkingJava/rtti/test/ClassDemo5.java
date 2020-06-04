package com.wangxu.ThinkingJava.rtti.test;

/**
 * 获取Class 对象的几种方式
 */
public class ClassDemo5 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过对象获取
        Test testIns = new Test();
        testIns.getClass();
        //通过类字面常量
        Class c = Test.class;
        //通过Class.forName();
        Class.forName("com.wangxu.ThinkingJava.rtti.test.Test");
    }
}
