package com.itcat.annotation;

import java.lang.annotation.*;

@MyAnnotation
public class annotationTest {

    @MyAnnotation
    public void method(){
        System.out.println("注解测试。。。");
    }
}

/**
 * 定义一个注解
 * Target 表示我们定义的注解可以用在那些地方（如：方法上、类上）
 * Retention 表示我们的注解在什么地方有效
 *            RUNTIME > CLASS > SOURCE
 * Documented 表示将我们的注解生成在Javadoc中
 * Inherited  表示子类可以继承父类的注解
 */

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{
    /**
     * 此处写注解内容
     */
}
