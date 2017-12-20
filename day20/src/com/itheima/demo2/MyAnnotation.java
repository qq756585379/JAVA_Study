package com.itheima.demo2;

//创建一个注解类
public @interface MyAnnotation {

    int age() default 0;

    String name() default "";

    String sex() default "";

    //	String value();
    String[] value();

//	MyAnno anno();

//	Color color();
}