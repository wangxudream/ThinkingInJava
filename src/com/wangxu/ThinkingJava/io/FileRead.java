package com.wangxu.ThinkingJava.io;

import java.io.*;

/**
 * @ClassName FileRead
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/2 23:13
 * @Version V1.0
 **/
public class FileRead {
    public static void main(String[] args) {
        File file = new File("D:\\test.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < 10000; i++) {
                writer.write("aaabbbccc");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
