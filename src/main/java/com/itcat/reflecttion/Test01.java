package com.itcat.reflecttion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//什么叫反射？
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class<?> c1 = Class.forName("com.itcat.reflecttion.User");
        System.out.println(c1);

        Class<?> c2 = Class.forName("com.itcat.reflecttion.User");
        Class<?> c3 = Class.forName("com.itcat.reflecttion.User");
        Class<?> c4 = Class.forName("com.itcat.reflecttion.User");
        //打印c2、c3、c4的hashCode，若hashCode一样，则说明是同一个类
        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都会被封装在Class对象中
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }
}

//创建一个实体类：pojo、entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private String name;
    private int id;
    private int age;
}