package com.wangxu.ThinkingJava;

import java.util.*;

/**
 * 测试HashMap和TreeMap
 */
public class MapDemo {
    public static void main(String[] args) {
        MapDemo mapDemo = new MapDemo();
//        Map<String, String> hmap = new HashMap();
//        Map<String, String> tmap = new TreeMap();
//        for (int i = 0; i < 9; i++) {
//            hmap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
//            tmap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
//        }

        Map<Student, String> hmap = new HashMap();
        Map<Student, String> tmap = new TreeMap();

        for (int i = 0; i < 9; i++) {
            String name = UUID.randomUUID().toString();
            hmap.put(mapDemo.new Student(name,i),name );
            tmap.put(mapDemo.new Student(name,i),name );
        }


        Iterator iterator = hmap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("hmap:" + iterator.next());
        }

        Iterator iterator2 = tmap.entrySet().iterator();
        while (iterator2.hasNext()) {
            System.out.println("tmap:" + iterator2.next());
        }
    }


    private class Student implements Comparable<Student> {
        private String name;
        private Integer age;

        public Student() {
        }

        public Student(String name, Integer age) {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }


        @Override
        public int compareTo(Student o) {
            if (this.age == o.age) {
                return 0;
            } else if (this.age > o.age) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
