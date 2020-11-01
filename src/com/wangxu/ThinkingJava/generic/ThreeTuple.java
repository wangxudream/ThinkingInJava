package com.wangxu.ThinkingJava.generic;

/**
 * 利用继承关系扩展元组
 *
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    protected final C data;

    public ThreeTuple(A state, B msg, C data) {
        super(state, msg);
        this.data = data;
    }

    public String toString() {
        return "state:" + super.state + ",msg:" + msg + ",data:" + data;
    }
}

class ThreeTupleTest {
    public ThreeTuple test1() {
        return new ThreeTuple("success", "操作成功", "data");
    }

    public ThreeTuple test2() {
        return new ThreeTuple(200, "操作成功", "data");
    }

    public static void main(String[] args) {
        ThreeTupleTest test = new ThreeTupleTest();
        ThreeTuple result1 = test.test1();
        ThreeTuple result2 = test.test2();
        System.out.println(result1);
        System.out.println(result2);
    }
}



