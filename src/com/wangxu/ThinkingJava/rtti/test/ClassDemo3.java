package com.wangxu.ThinkingJava.rtti.test;

/**
 *基本类型和包装类的类型信息
 */
public class ClassDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        System.out.println(int.class);
        System.out.println(Integer.class);
        System.out.println(Integer.TYPE);
        System.out.println(int.class == Integer.TYPE);
    }
//    int
//    class java.lang.Integer
//    int
//    true
//    0
//    Init static filed
//    class com.wangxu.ThinkingJava.rtti.test.Tes
}

