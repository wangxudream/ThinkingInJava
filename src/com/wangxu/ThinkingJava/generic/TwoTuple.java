package com.wangxu.ThinkingJava.generic;

/**
 * 元组概念，利用元组从一个方法中间接返回多个对象
 *
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A, B> {

    //    private final A state;
    protected final A state;
    protected final B msg;

    public TwoTuple(A state, B msg) {
        this.state = state;
        this.msg = msg;
    }

    public String toString() {
        return "state:" + state + ",msg:" + msg;
    }
}

class TwoTupleTest {
    public TwoTuple test1() {
        return new TwoTuple("success", "操作成功");
    }

    public TwoTuple test2() {
        return new TwoTuple(200, "操作成功");
    }

    public static void main(String[] args) {
        TwoTupleTest test = new TwoTupleTest();
        TwoTuple result1 = test.test1();
        TwoTuple result2 = test.test2();
        System.out.println(result1);
        System.out.println(result2);
    }
}


