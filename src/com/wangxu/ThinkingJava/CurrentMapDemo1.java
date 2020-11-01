package com.wangxu.ThinkingJava;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用currentmap统计字符出现的次数
 * 1、这个demo先展示了错误的做法(操作的非原子性)
 */
public class CurrentMapDemo1 {
    public static void main(String[] args) throws InterruptedException {
        String str = "测试字符串abc测试";
        CharCount charCount = new CharCount();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            pool.submit(() -> {
                charCount.count(str);
            });
        }
        pool.shutdown();
        while (!pool.isTerminated()) {
            Thread.sleep(10);
            System.out.println("pool is running");
        }

        System.out.println(charCount.getCountResult());

    }

    private static class CharCount {
        private final Map<Character, AtomicInteger> countMap;

        public CharCount() {
            this.countMap = new ConcurrentHashMap<>();
        }

        public void count(String str) {
            if (empty(str)) {
                return;
            }
            count(str.toCharArray());
        }

//        public void count(char[] chars) {//synchronized
//            if (empty(chars)) {
//                return;
//            }
//            //currentMap的put和get方法内部时线程安全的
//            //下面的操作时非线程安全的（非原子的操作（get和put组合在一起的操作））
//            //可以在count方法外部加锁，但这会使效率降低，失去了使用currentMap的意义
//            for (char c : chars) {
//                if (countMap.containsKey(c)) {
//                    countMap.get(c).getAndIncrement();
//                } else {
//                    countMap.put(c, new AtomicInteger(0));
//                }
//            }
//        }

        public void count(char[] chars) {
            if (empty(chars)) {
                return;
            }
            //currentMap的put和get方法内部时线程安全的
            //下面的操作时非线程安全的（非原子的操作（get和put组合在一起的操作））
            //可以在count方法外部加锁，但这会使效率降低，失去了使用currentMap的意义
            for (char c : chars) {
                //absent缺席 compute 计算
//                countMap.computeIfAbsent(); 如果不存在key，则将key和计算生成的value同时放入Map,返回结果
//                countMap.computeIfPresent();
                AtomicInteger res = countMap.computeIfAbsent(c, (key) -> new AtomicInteger(0));
                //利用原子累加类
                res.getAndIncrement();
            }
        }


        private boolean empty(char[] chars) {
            if (chars == null || chars.length == 0) {
                return true;
            }
            return false;
        }

        private boolean empty(String str) {
            if (str == null || str.toCharArray().length == 0) {
                return true;
            }
            return false;
        }

        //装饰器模式返回不可修改的Map
        public Map getCountResult() {
            return Collections.unmodifiableMap(countMap);
        }
    }
}
