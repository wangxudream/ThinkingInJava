package com.wangxu.ThinkingJava.generic;

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Generator create(Class type) {
        return new BasicGenerator(type);
    }

    public static void main(String[] args) {
        Generator generator = BasicGenerator.create(ObjectCount.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
    }


}

class ObjectCount {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public String toString() {
        return "ObjectCount:" + id;
    }
}
