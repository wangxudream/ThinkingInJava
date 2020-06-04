package com.wangxu.ThinkingJava.rtti.test;

import com.wangxu.ThinkingJava.rtti.Circle;
import com.wangxu.ThinkingJava.rtti.Shape;
import com.wangxu.ThinkingJava.rtti.Square;
import com.wangxu.ThinkingJava.rtti.Triangle;

import java.util.Arrays;
import java.util.List;

/**
 * 向上转型后依旧能获得原先的Class对象
 */
public class ClassDemo2 {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape:shapes){
            System.out.println(shape.getClass());
        }
    }
}
