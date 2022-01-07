package com.wangxu.ThinkingJava.annotation;

import java.lang.reflect.Method;

public class AnnotationDemo {
    public static void main(String[] args) {
        try {
            Class cla = AnnotationDemo.class;
            Method method = cla.getMethod("test");
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println(annotation.gender());
                System.out.println(annotation.age());
            }

        } catch (Exception e) {

        } finally {

        }
    }

}
