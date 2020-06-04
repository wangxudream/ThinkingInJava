package com.wangxu.ThinkingJava.string;

/**
 * 不可变字符串
 * String的任何操作都会返回一个新的String对象
 */
public class StringDemo {
    public static void main(String[] args) {
        String oldStr = "old";
        System.out.println(oldStr);
        String newStr = oldStr.toUpperCase();
        System.out.println(newStr);
        System.out.println(oldStr);

    }
}
