package com.wangxu.ThinkingJava.rtti;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 利用递归计算每个类的实例的数量
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj) {
        Class c = obj.getClass();
        if (!baseType.isAssignableFrom(c)) {
            return;
//            throw new RuntimeException("incorrct type");
        }

        countClass(obj.getClass());

    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        //统计超类实例数量
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            //递归
            countClass(superClass);
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Class<?>, Integer> entry : entrySet()) {
            builder.append(entry.getKey().getSimpleName());
            builder.append(":" + entry.getValue());
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        TypeCounter circleCounter = new TypeCounter(Circle.class);
        TypeCounter squareCounter = new TypeCounter(Square.class);
        TypeCounter triangleCounter = new TypeCounter(Triangle.class);
        for (int i = 0; i < 10; i++) {
            int flag = random.nextInt(3);
            Shape shape = null;
            if (flag==0){
                shape = new Circle();
            }else if (flag ==1){
                shape = new Square();
            }else if (flag ==2){
                shape = new Triangle();
            }

            circleCounter.count(shape);
            squareCounter.count(shape);
            triangleCounter.count(shape);
        }

        System.out.println(circleCounter.toString());
        System.out.println(squareCounter.toString());
        System.out.println(triangleCounter.toString());
    }

}
