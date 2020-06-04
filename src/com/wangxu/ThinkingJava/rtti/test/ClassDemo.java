package com.wangxu.ThinkingJava.rtti.test;

/**
 *简单查看Class 对象包含的信息
 */
public class ClassDemo {
    public static void main(String[] args) {
        Class aClass = null;
        try {
            aClass = Class.forName("com.wangxu.ThinkingJava.rtti.test.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass);

        for (Class c : aClass.getInterfaces()) {
            System.out.println(c);
        }

        System.out.println("SimpleName:" + aClass.getSimpleName());
        System.out.println("Superclass:" + aClass.getSuperclass());

        try {
            //需要有无参构造函数
            Object object = aClass.newInstance();
            System.out.println(object);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

interface HasBatteries {
}

interface Shoots {
}

interface Waterproof {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }

    void say() {
        System.out.println("Toy");
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }

    @Override
    void say() {
        System.out.println("FancyToy");
    }

}



