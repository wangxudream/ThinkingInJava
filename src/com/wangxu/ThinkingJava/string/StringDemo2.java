package com.wangxu.ThinkingJava.string;

/**
 * String
 */
public class StringDemo2 {
    public static void main(String[] args) {
        /**/
        String str1 = "Test";
        String str2 = "Test";
        System.out.println(str1 ==str2);
        /**/
        String str3 = new String("Test");
        System.out.println(str1 == str3);
        /**/
        String str4 = "a" + "b" + "c";
        String str5 = "abc";
        System.out.println(str4 == str5);
        /**/
        String str6 = "xy";
        String str7 = "xyc";
        String str8 = str6+"c";
        System.out.println(str7 == str8);
    }
}
