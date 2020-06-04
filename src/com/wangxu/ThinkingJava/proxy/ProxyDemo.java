package com.wangxu.ThinkingJava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {

    public static void consumer(Object sale, Double dou) {
        System.out.println("result:" + ((Sale)sale).sale(dou));
    }

    public static void consumer2(Object sale2, Double dou) {
        System.out.println("result:" + ((Sale2)sale2).sale2(dou));
    }

    public static void main(String[] args) {
        SaleIns saleIns = new SaleIns();
        MyInvocationHandler myHandler = new MyInvocationHandler(saleIns);
        Sale sale = (Sale) Proxy.newProxyInstance(Sale.class.getClassLoader(), new Class[]{Sale.class, Sale2.class}, myHandler);
        consumer(sale, 100.0);
        consumer2(sale, 100.0);
    }
}

interface Sale {
    Double sale(Double money);

}


interface Sale2 {
    Double sale2(Double money);

}

class SaleIns implements Sale, Sale2 {

    public Double sale(Double money) {
        return money * 0.8;
    }

    public Double sale2(Double money) {
        return money * 0.7;
    }
}


class MyInvocationHandler implements InvocationHandler {
    private Object object;


    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Object o :
                args) {
            System.out.println(o);
        }
        return method.invoke(object, args);
    }
}



