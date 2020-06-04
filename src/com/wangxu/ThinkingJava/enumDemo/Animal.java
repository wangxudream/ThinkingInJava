package com.wangxu.ThinkingJava.enumDemo;

public enum Animal {
    DOG {
        public void say() {
            System.out.println("DOG WANG...");
        }

        void skill() {
            System.out.println("Dog CATCH MOUSE");
        }
    },
    SHEEP {
        public void say() {
            System.out.println("SHEEP MIE...");
        }

        public void eat() {
            System.out.println("SHEEP EAT GRASS");
        }
    }, CAT {
        public void say() {
            System.out.println("CAT MIAO...");
        }

        public void eat() {
            System.out.println("CAT EAT FISH");
        }
    };

    public abstract void say();

    public void eat() {
        System.out.println("ANIMAL EAT FOOD");
    }

    public static void main(String[] args) {
        for (Animal animal : Animal.values()) {
            animal.say();
            animal.eat();
        }
    }

}
