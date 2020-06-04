package com.wangxu.ThinkingJava.string;

/**
 * 测试编译器的优化
 */
public class StringDemo3 {
    public static void main(String[] args) {
        String str = "test";
        String s = str + "2020-05-24" + " in hangzhou";
    }
}

//Compiled from "StringDemo3.java"
//public class com.wangxu.ThinkingJava.string.StringDemo3 {
//public com.wangxu.ThinkingJava.string.StringDemo3();
//        Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//
//public static void main(java.lang.String[]);
//        Code:
//        0: ldc           #2                  // String test
//        2: astore_1
//        3: new           #3                  // class java/lang/StringBuilder
//        6: dup
//        7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
//        10: aload_1
//        11: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
//        14: ldc           #6                  // String 2020-05-24 in hangzhou
//        16: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
//        19: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
//        22: astore_2
//        23: return
//        }