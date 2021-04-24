package com.wangxu.ThinkingJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName ComparatorDemo
 * @Description: Comparator接口的使用
 * @Author kataer
 * @Date 2020/11/30 21:46
 * @Version V1.0
 **/
public class ComparatorDemo {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(0);
        intList.add(-1);
        intList.add(-9);
        intList.add(3);
        intList.add(9);
        intList.add(2);
        Collections.sort(intList);
        System.out.println(intList);
        Collections.sort(intList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(intList);
    }
}
