package com.wangxu.ThinkingJava.generic;

public class LostInformation2 {

}

class Trainee<T extends Star> {
    private T t;

    public void test(){
        System.out.println(t instanceof Star);
        t.basketball();
        t.jump();
        t.rap();
    }
}

class Kun implements Star {

    public void sayHello() {
        System.out.println("Hello everybody,I am Kun");
    }

    @Override
    public void basketball() {
        System.out.println("BASKETBALL");
    }

    @Override
    public void jump() {
        System.out.println("JUMP");
    }

    @Override
    public void rap() {
        System.out.println("RAP");
    }
}

interface Star {
    void basketball();

    void jump();

    void rap();
}