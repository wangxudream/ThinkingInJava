package com.wangxu.ThinkingJava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String name() default "defaultName";

    int age() default 18;

    Gender gender() default Gender.MAN;

    /**
     * 注解元素类型包括1、基本类型 2、String 3、枚举 4、Class 5、注解
     */
}

