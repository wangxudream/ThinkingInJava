package com.wangxu.ThinkingJava.generic;

/**
 * 应用于类上的泛型
 * 创建类实例时需指定具体类型
 * 编译器会对类型进行检查
 *
 * @param <T>
 */
public class Holder<T> {
    private T a;

    public Holder(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder<String> holder = new Holder<>("String");
        System.out.println(holder.a);
//        holder.set(2); 类型错误
    }
}
