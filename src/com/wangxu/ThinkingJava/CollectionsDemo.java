package com.wangxu.ThinkingJava;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("E1", "E1");
        map.put("E2", "E2");
        Map unEditMap = Collections.unmodifiableMap(map);
        unEditMap.put("E2", "TEST");
        map.put("E1", "Test");
        System.out.println(map);
    }
}
