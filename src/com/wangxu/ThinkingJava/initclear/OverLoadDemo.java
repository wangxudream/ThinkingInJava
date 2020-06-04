package com.wangxu.ThinkingJava.initclear;

public class OverLoadDemo {
    public static void main(String[] args) {
        OverLoadDemo demo = new OverLoadDemo();
        char charAge = 'a';
        byte byteAge = 25;
        demo.sayAge(charAge);
        demo.sayAge(byteAge);
    }

    public void sayAge(int age){
        System.out.println("int: "+age);
    }

//    public int sayAge(int age){
//        System.out.println("int: "+age);
//        return age;
//    }

    public void sayAge(byte age){
        System.out.println("byte: "+age);
    }

    public void sayAge(short age){
        System.out.println("short: "+age);
    }

    public void sayAge(Integer age){
        System.out.println("Integer: "+age);
    }

}
