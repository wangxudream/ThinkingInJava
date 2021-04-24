package com.wangxu.ThinkingJava;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TDemo
 * @Description: 泛型使用
 * @Author kataer
 * @Date 2020/11/29 15:17
 * @Version V1.0
 **/
public class TDemo {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(123);
        try {
            Method addMethod = integers.getClass().getMethod("add", Object.class);
            addMethod.invoke(integers,"123");
            final Integer integer = integers.get(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
