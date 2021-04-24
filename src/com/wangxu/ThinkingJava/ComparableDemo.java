package com.wangxu.ThinkingJava;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName ComparableDdemo
 * @Description: Comparable 接口的使用
 * @Author kataer
 * @Date 2020/11/29 22:30
 * @Version V1.0
 **/
public class ComparableDemo {
    //cannot be cast to java.lang.Comparable
    public static void main(String[] args) {
        TreeMap<Person, String> treeMap = new TreeMap<>();//使用person类的CompareTo
        TreeMap<Person, String> treeMap2 = new TreeMap<>(new MyComparator());//使用MyComparator的CompareTo
        treeMap.put(new Person("A", 22), "1");
        treeMap.put(new Person("A", 15), "2");
        treeMap.put(new Person("B", 3), "3");
        treeMap.put(new Person("B", 3), "4");
        treeMap.put(new Person("B", 0), "5");

        treeMap2.put(new Person("A", 22), "1");
        treeMap2.put(new Person("A", 15), "2");
        treeMap2.put(new Person("B", 3), "3");
        treeMap2.put(new Person("B", 3), "4");
        treeMap2.put(new Person("B", 0), "5");
        for (Map.Entry<Person, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (Map.Entry<Person, String> entry : treeMap2.entrySet()) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
    }

    public static class Person implements Comparable<Person> {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Person o) {
            int nameCompare = this.name.compareTo(o.name);
            int ageCompare = this.age.compareTo(o.age);
            return nameCompare > 0 ? 1 : (ageCompare > 0 ? 1 : (ageCompare == 0 ? 0 : -1));
        }
    }


    /**
     * @Author kataer
     * @Description //自定义的排序方式
     * @Date 21:37 2020/11/30
     * @Param
     * @return
     **/
    public static class MyComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.age > o2.age ? 1 : (o1.age == o2.age ? 0 : -1);
        }
    }
}
