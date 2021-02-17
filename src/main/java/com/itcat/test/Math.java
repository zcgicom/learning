package com.itcat.test;

import java.util.ArrayList;

public class Math {
    public static final Integer CONSTANT = 666;
    public static Object obj = new Object();

    public static void main(String[] args) {
        Math math = new Math();
//        math.compute();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(7);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(1);
        }
    }
    public int compute(){//一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b)*10;
        return c;
    }
}
