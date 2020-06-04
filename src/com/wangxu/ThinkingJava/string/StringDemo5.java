package com.wangxu.ThinkingJava.string;

public class StringDemo5 {


    public static void main(String[] args) {
        DaHuan dauan = new DaHuan();
        System.out.println( dauan.toString());
    }

}

class Animal{}

class Dog extends Animal{

}

class DaHuan extends Dog{
    private String name;

    @Override
    public String toString() {
        return "DaHuan{" +
                "name='" + name + ";address="+super.toString()+" }";
    }
}