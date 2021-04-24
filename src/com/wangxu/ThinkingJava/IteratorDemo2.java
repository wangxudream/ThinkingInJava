package com.wangxu.ThinkingJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName IteratorDemo2
 * @Description: TODO
 * @Author kataer
 * @Date 2020/11/30 23:11
 * @Version V1.0
 **/
public class IteratorDemo2 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

//        test1(integerList);
        test2(integerList);
    }

    public static void test1(List<Integer> integerList) {
        //增强循环使用的是iterator,会检查modCount
        for (Integer integer : integerList) {
            if (integer.equals(1)) {
//                integerList.remove(integer);ConcurrentModificationException,不会修改modCount
                integerList.remove(1);//ConcurrentModificationException,不会修改modCount
            }
        }
    }

    public static void test2(List<Integer> integerList) {
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
            if (integer.equals(2)) {
                iterator.remove();
            }
        }

        System.out.println(integerList);
    }
}
