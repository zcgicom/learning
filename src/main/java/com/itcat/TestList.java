package com.itcat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *java.util.List接口 extents Collection接口
 * List接口的特点：
 *      1.有序的结合，存储元素和取出元素的顺序一致(存储123 取出123)
 *      2.有索引，包含了一些带有索引的方法
 *      3.允许存储重复的元素
 *
 * List接口中带有索引的方法(特有)
 *      - public void add(int index, E element):将新增的元素，添加到指定索引位置
 *      - public E get(int index):获取集合中指定索引处的元素
 *      - public E remove(int index):将集合中指定索引处的元素移除，并返回被移除的元素
 *      - public E set(int index, E element):更新集合中指定索引处的元素，并返回当前索引处更新前的元素
 *
 * 注意：
 *      操作索引时，要防止索引的越界异常
 *      IndexOutBoundsException  集合索引越界异常
 *      ArrayIndexOutBoundsException  数组索引越界异常
 *      StringIndexOutBoundsException  字符串索引越界异常
 */

public class TestList {
    public static void main(String[] args) {
        //创建一个List集合对象，多态方式
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        //打印集合
        System.out.println(list);//[a,b,c,d,a] 打印结果不是地址，则说明重写了toString方法

        //public void add(int index, E element):将新增的元素，添加到指定索引位置
        list.add(3,"aop");
        System.out.println(list);

        //public E set(int index, E element):更新集合中指定索引处的元素，并返回当前索引处更新前的元素
        list.set(5,"ioc");
        System.out.println(list);

        //遍历集合
        System.out.println("for循环遍历：");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.print(s+" ");
        }
        //使用迭代器遍历集合
        System.out.println("\n迭代器遍历：");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.print(s+" ");
        }

        //使用增强for循环遍历
        System.out.println("\n增强for循环遍历：");
        for (String s : list) {
            System.out.print(s+" ");
        }
    }
}
