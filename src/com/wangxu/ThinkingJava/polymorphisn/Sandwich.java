package com.wangxu.ThinkingJava.polymorphisn;


/**
 * 初始化的顺序
 */
class Meal {
    protected static String staticFiled;
    private String filed = initFiles();

    static {
        System.out.println(Lunch.filed);
        staticFiled = "STATICFILED";
        System.out.println("Meal Static");
    }

    public Meal() {
        System.out.println(Lunch.filed);
        System.out.println("Meal()");
    }

    private String initFiles() {
        System.out.println("filed:" + filed);
        return "Filed";
    }
}

class Bread {
    static {
        System.out.println("Bread Static");
    }

    public Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    static {
        System.out.println("Cheese Static");
    }

    public Cheese() {
        System.out.println("Cheese()");
    }
}

class Lunch extends Meal {
    public static String filed = "Lunch Static Filed";

    static {
        System.out.println("Lunch Static");
    }

    public Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    static {
        System.out.println("PortableLunch Static");
    }

    public PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

public class Sandwich extends PortableLunch {
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
//        new Sandwich();
    }
}
/**
 * 1、直接运行Main方法
 * Meal Static
 * Lunch Static
 * PortableLunch Static
 * 2、创建对象
 * Meal Static
 * Lunch Static
 * PortableLunch Static
 * filed:null
 * Meal()
 * Lunch()
 * PortableLunch()
 * Bread Static
 * Bread()
 * Cheese Static
 * Cheese()
 * Sandwich()
 * 结论:
 * 1、先初始化所有静态代码块和静态域（从继承树向下，同一个类内按照声明的顺序）
 * 2、从继承树往下初始化成员变量，调用构造方法
 */
