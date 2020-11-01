package com.wangxu.ThinkingJava.polymorphisn;


public class Demo2 {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.new Sub(5);
    }

    public class Super {
        private int filed = 1;

        public Super() {
            System.out.println("before show()");
            show();
            System.out.println("after show()");
        }

        public void show() {
            System.out.println("Super show(),filed:" + filed);
        }
    }

    public class Sub extends Super {
        private int filed = 1;

        public Sub(int filed) {
            System.out.println("before Sub(),filed:" + this.filed);
            this.filed = filed;
            System.out.println("after Sub(),filed:" + filed);
        }

        public void show() {
            System.out.println("Sub show(),filed:" + filed);
        }
    }
}

