package com.wangxu.ThinkingJava;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName AsListDemo
 * @Description: 测试asList的坑
 * @Author kataer
 * @Date 2020/11/30 23:26
 * @Version V1.0
 **/
public class AsListDemo {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
        Integer[] integers = new Integer[]{1, 2, 3};
        List<Integer> integerList = Arrays.asList(integers);
        System.out.println(integerList.getClass());//java.util.Arrays$ArrayList
        integerList.add(4);//UnsupportedOperationException 未实现AbstractList的抽象方法remove，add，clear
        //    public void add(int index, E element) {
        //        throw new UnsupportedOperationException();
        //    }
    }

    public static void test2() {
        //不支持基本类型数组
        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//[I@1b6d3586
        System.out.println(myList.get(1));//ArrayIndexOutOfBoundsException
    }
}
