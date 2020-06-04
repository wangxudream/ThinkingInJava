package com.wangxu.ThinkingJava.string;

/**
 * 测试编译器的优化
 */
public class StringDemo4 {
    public  String implicit() {
        String str = "test";
        for (int i = 0; i < 10; i++) {
            //在循环中创建StringBuilder对象
            str += i;
        }
        return str;
    }

    public String explicit() {
        StringBuilder builder = new StringBuilder("test");
        for (int i = 0; i < 10; i++) {
            builder.append(i);
        }
        return builder.toString();
    }

    public String append(){
        String a = "str1";
        String b = "str2";
        StringBuilder builder = new StringBuilder();
        builder.append(a+":"+b);
        return builder.toString();
    }

}
