package com.wangxu.ThinkingJava.generic;

import com.wangxu.ThinkingJava.generic.coffee.Americano;
import com.wangxu.ThinkingJava.generic.coffee.Cappuccino;
import com.wangxu.ThinkingJava.generic.coffee.Coffee;
import com.wangxu.ThinkingJava.generic.coffee.Mocha;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = {Cappuccino.class, Mocha.class, Americano.class};
    private static Random random = new Random(47);

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    private int size = 0;

    public Coffee next() {
        try {
            System.out.println("CoffeeGenerator next()");
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            System.out.println("CoffeeIterator next()");
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }

        CoffeeGenerator generator2 = new CoffeeGenerator(5);
        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }
    }
}
