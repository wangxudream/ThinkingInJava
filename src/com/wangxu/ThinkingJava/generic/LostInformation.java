package com.wangxu.ThinkingJava.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LostInformation {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        System.out.println(Arrays.toString(strings.getClass().getTypeParameters()));
        //[E] 丢失了类型信息，只是获取了占位符 public class ArrayList<E>
    }
}

class LostTest<T> {
    private T type;

    public LostTest(T type) {
        this.type = type;
    }

    public void getInfo() {
        //无法找到f()方法
//      type.f();
    }
}


class Info {
    public void f() {
        System.out.println("Info f()");
    }
}