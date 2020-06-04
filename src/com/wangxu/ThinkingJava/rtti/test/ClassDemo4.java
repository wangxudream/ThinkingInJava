package com.wangxu.ThinkingJava.rtti.test;

/**
 * 测试.class方法和编译期常量使用不会导致Class对象的初始化（会导致类加载）
 */
public class ClassDemo4 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("test start ");
        System.out.println("before use Test.class");
        Class c = Test.class;
        System.out.println(c.getSuperclass());
        System.out.println("after use Test.class");
        System.out.println("before use Test.static_final");
        System.out.println(Test.static_final);
        System.out.println("after use Test.static_final");
        System.out.println("after Class.forName()");
        Class.forName("com.wangxu.ThinkingJava.rtti.test.Test");
        System.out.println("after Class.forName()");
        System.out.println("test end");
    }
//    test start
//    before use Test.class
//    after use Test.class
//    before use Test.static_final
//            STATIC_FINAL
//    after use Test.static_final
//    after Class.forName()
//    Init static filed
//    after Class.forName()
//    test end
}

class Test {
    public static final String static_final = "STATIC_FINAL";

    static {
        System.out.println("Init static filed");
    }

    public void useStaticFinal() {
        System.out.println(static_final);
    }
}
