package com.itheima.demo3;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited

//改变自定义注解的存活范围
@Retention(RetentionPolicy.RUNTIME)

//指定该注解能用在什么地方
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyTest {
    long timeout() default -1;
}

