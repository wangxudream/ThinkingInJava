package com.wangxu.ThinkingJava;

/**
 * 用户线程Thread1退出后，Jvm就正常退出
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                int time = 0;
                for (; ; ) {
                    Thread.sleep(1000);
                    System.out.println(++time);
                }
            } catch (Exception e) {

            }
        });
        thread.setDaemon(true);
        thread.start();

        Thread thread1 = new Thread(() -> {
            try {
                int time = 0;
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println(++time);
                }
            } catch (Exception e) {

            }
        });
        thread1.start();
    }
}
