package com.wangxu.ThinkingJava.enumDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Meal {
    FRUIT(Food.Fruit.class),
    SPICES(Food.Spices.class),
    MEET(Food.Meet.class),
    VEGETABLS(Food.vegetabls.class);

    private Food[] values;

    Meal(Class<? extends Food> kind) {
        //利用class对象获取所有
        values = kind.getEnumConstants();
    }

    public static List<Food> randSelect() {
        List<Food> foods = new ArrayList<Food>();
        Random random = new Random();
        for (Meal meal : Meal.values()) {
            int index = random.nextInt(meal.values.length);
            foods.add(meal.values[index]);
        }
        return foods;
    }

    public static void main(String[] args) {
        List<Food> foods = Meal.randSelect();
        System.out.println(foods);
    }

}