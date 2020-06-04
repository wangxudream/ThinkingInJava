package com.wangxu.ThinkingJava.enumDemo;

public interface Food {
    enum Fruit implements Food{
        APPLE,BANANA,ORANGE;
    }

    enum Spices implements Food{
        SALT,SUGER;
    }

    enum Meet implements Food{
        PORK,BEEF,FISH;
    }

    enum vegetabls implements Food{
        PATATO,TOMATO;
    }
}
