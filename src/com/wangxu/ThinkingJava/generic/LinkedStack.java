package com.wangxu.ThinkingJava.generic;


public class LinkedStack<T> {
    private Node top = new Node();//末端哨兵

    private class Node {
        T item;
        Node next;

        Node() {
            this.item = null;
            this.next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        public boolean end() {
            return item == null && next == null;
        }
    }

    public void push(T item) {
        //设置新的top
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            //top移动
            top = top.next;
        }
        return result;
    }


}
