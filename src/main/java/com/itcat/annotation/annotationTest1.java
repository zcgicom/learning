package com.itcat.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个注解
 */
public class annotationTest1 {
    //注意：注解可以显示赋值，如果没有默认值(使用"default"设置默认值)，我们必须给注解参数赋值。
    @MyAnnotation1(name = "itcat")//此时必须给出成员参数名，并指定参数（设置了默认值的参数可以不写）
    public void method1(){

    }

    @MyAnnotation2("itcat")//此时只有一个成员参数，可以省略参数名（前提是使用了"value"作为参数名）
    public void method2(){

    }
}

//测试含有多个参数成员
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1{
    //注解的参数格式：参数类型 + 参数名();
    String name() default "";
    int age() default 0;
    int id() default -1;//如果默认值为-1，表示不存在。类似于indexof，如果找不到就返回-1.

    String[] schools() default {"郑州大学，河南大学"};
}

//测试只有一个参数成员，建议使用"value"命名
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String value();
}