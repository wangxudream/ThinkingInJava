package com.wangxu.ThinkingJava.initclear;

import java.lang.reflect.Field;

public class InitDemo {
    public static void main(String[] args) throws IllegalAccessException {
        Student stu = new Student("Tom");
        stu.setName("Tom Father");
        System.out.println(stu.getName());
        Field[] fields = stu.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Class superClass = stu.getClass().getSuperclass();
        Field[] superFields = superClass.getDeclaredFields();
        for (Field field : superFields) {
            System.out.println(field.getName());
            System.out.println(field.get(stu));
        }

    }
}

class Person {
    protected String name;

    protected String tel;
}

class Student extends Person {
    private String name;
    private Integer age;
    private String address;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Integer age) {
        this(name);
        this.age = age;
    }

    public Student(String name, Integer age, String address) {
        this(name, age);
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        super.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}