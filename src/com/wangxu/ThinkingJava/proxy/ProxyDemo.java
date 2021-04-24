package com.wangxu.ThinkingJava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        InterfaceImpl impl = new InterfaceImpl();
        MyInvocationHandler myHandler = new MyInvocationHandler(impl);
        Sale sale = (Sale) Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(), new Class[]{Sale.class, Hello.class}, myHandler);
        sale.sale(100.0);
        sale.repair(100.0);
        ((Hello) sale).hello();
    }
}

interface Sale {
    Double sale(Double money);

    Double repair(Double money);

}

interface Hello {
    void hello();

}


class InterfaceImpl implements Sale, Hello {

    @Override
    public Double sale(Double money) {
        System.out.println("sale method>>>>>>>>>");
        return money;
    }

    @Override
    public Double repair(Double money) {
        System.out.println("repair method>>>>>>>>>");
        return money;
    }

    @Override
    public void hello() {
        System.out.println("hello method>>>>>>>>>");
    }
}


class MyInvocationHandler implements InvocationHandler {
    private Object object;


    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(proxy);
        System.out.println("before method>>>>>>>>>");
        System.out.println(method.getName());
        Object res = method.invoke(object, args);
        System.out.println("after method>>>>>>>>>");
        return res;
    }
}



