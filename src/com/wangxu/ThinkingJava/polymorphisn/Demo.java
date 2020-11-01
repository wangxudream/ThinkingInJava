package com.wangxu.ThinkingJava.polymorphisn;

/**
 * 1、java中除了static和final(private方法属于final方法，其他方法都是动态绑定)
 * 2、Sub对象向上转型时，任何域访问操作将会有编译器解析，不是多态的
 */
public class Demo {
}

class Super {
    public int filed = 0;

    public int getFiled() {
        return filed;
    }

    public static void staticMethod() {
        System.out.println("Super staticMethod");
    }

    public final void finalMethod() {
        System.out.println("Super staticMethod");
    }

    private void privateMethod() {
        System.out.println("Super privateMethod");
    }

    public static void main(String[] args) {
        Super sup = new Sub();
        sup.privateMethod();//Super privateMethod
        sup.staticMethod();//Super staticMethod
    }
}

class Sub extends Super {
    public int filed = 1;

    public int getFiled() {
        return filed;
    }

    public int getSuperFiled() {
        return super.filed;
    }


    public static void staticMethod() {
        System.out.println("Super staticMethod");
    }

    private void privateMethod() {
        System.out.println("Super privateMethod");
    }

    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.println("sup.filed:" + sup.filed);//得到的是Super的filed
        System.out.println("sup.getFiled():" + sup.getFiled());
        Sub sub = new Sub();

        System.out.println("sup.filed:" + sup.filed);
        System.out.println("sup.getFiled():" + sup.getFiled());
        System.out.println("sub.getSuperFiled():" + sub.getSuperFiled());
    }
}

