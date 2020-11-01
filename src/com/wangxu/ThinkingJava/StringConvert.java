package com.wangxu.ThinkingJava;

public class StringConvert {
    public static void main(String[] args) {
        String str = "abc123";
        char[] chars = str.toCharArray();
        int n = chars.length - 1;
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            char tmp = chars[n - j];
            chars[n - j] = chars[j];
            chars[j] = tmp;
        }
        System.out.println(new String(chars));
        //利用StringBuilder的convert方法
        StringBuilder builder = new StringBuilder("abc123");
        builder.reverse();
        System.out.println(builder.toString());
    }

}
