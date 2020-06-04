package com.wangxu.ThinkingJava.rtti.test;

/**
 * 测试 instanceof /isInstance/class对象比较的异同
 */
public class ClassDemo7 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        test(animal);
        System.out.println("------------");
        test(dog);
    }

    public static void test(Object obj) {
        System.out.println(obj instanceof Animal);
        System.out.println(obj instanceof Dog);
        System.out.println(Animal.class.isInstance(obj));
        System.out.println(Dog.class.isInstance(obj));
        System.out.println(obj.getClass() == Animal.class);
        System.out.println(obj.getClass() == Dog.class);
        System.out.println(obj.getClass().equals(Animal.class));
        System.out.println(obj.getClass().equals(Dog.class));
    }
}

class Animal {

}

class Dog extends Animal {

}