package com.itcat;

import java.util.LinkedList;

/**
 * java.util.LinkedList集合 implements List接口
 * LinkedList集合是List接口的链接列表实现，它是一个双向链表。数据存储的结构是链表结构，方便元素添加。删除的集合。
 * LinkedList集合的特点：
 *      1.底层是一个链表结构：查询慢，增删快
 *      2.内部包含了大量的首尾元素操作方法
 * 注意：
 *      此实现不是同步的，如果多个线程同时访问一个链接列表，而其中至少一个线程从结构上修改了该列表，则必须保持外同步
 *      在实际开发中对一个集合元素的添加与删除经常涉及到首尾操作，LinkedList提供了大量的首尾操作方法。
 *      使用LinkedList集合特有的方法，不能使用多态(多态看不到子类特有的方法)
 *
 * LinkedList常用操作：
 *      - public void addFirst(E e):将指定元素插入此列表的开头
 *      - public void addLast(E e):将指定元素添加到此列表的结尾
 *      - public void push(E e):将元素推入此列表所表示的堆栈  此方法等效于addFirst(E)
 *
 *      - public E getFirst():返回当前列表的第一个元素
 *      - public E getLast():返回当前列表的最后一个元素
 *
 *      - public E removeFirst():移除并返回此列表的第一个元素
 *      - public E removeLast():移除并返回此列表的最后一个元素
 *      - public E remove(int index):移除此列表中指定位置的元素
 *      - public E pop():从此列表所表示的堆栈处弹出一个元素  此方法等效于removeFirst()
 *
 *      - public boolean isEmpty():如果列表不包含元素，则返回true
 */
public class TestLinkedList {

    public static void main(String[] args) {
        showAdd();
    }
    public static void showAdd(){
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<String>();
        /**
         *  - public void addFirst(E e):将指定元素插入此列表的开头
         *  - public void addLast(E e):将指定元素添加到此列表的结尾
         *  - public void push(E e):将元素推入此列表所表示的堆栈  此方法等效于addFirst(E)
         */
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.print(linked+" ");//[a,b,c]

        String s = linked.removeFirst();
        System.out.println("移除的元素："+s);

        linked.clear();//情况集合元素  执行该语句后在获取集合中的元素会报NoSuchElementException异常
        System.out.println(linked);
        //通过isEmpty()判断是否为空
        if(!linked.isEmpty()){
            String first = linked.getFirst();
            System.out.println("第一个元素："+first);
        }
        System.out.println();

        //linked.addFirst("e");
        linked.push("e");
        System.out.println(linked+" ");


    }
}
