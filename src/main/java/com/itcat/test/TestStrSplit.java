package com.itcat.test;

import java.util.Arrays;

/**
 * String str ="";
 * System.out.print(str.split(",").length);
 *
 * String split这个方法默认返回一个数组，如果没有找到分隔符，会把整个字符串当成一个长度为1的字符串数组返回到结果，
 * 所以此处结果就是1
 */
public class TestStrSplit {
    public static void main(String[] args) {
        String str1 = "";
        String str2 = "123";
        String str3 = "12,3";
        int[] s = {1};
        System.out.println("#"+s.length+"#");
        System.out.println(str1.length());
        System.out.println(str1.split(",").length+":"+Arrays.toString(str1.split(",")));
        System.out.println(str2.split(",").length+":"+Arrays.toString(str2.split(",")));
        System.out.println(str3.split(",").length+":"+Arrays.toString(str3.split(",")));
        System.out.println("=====================");

        Integer a = 127;
        Integer b = 127;
        Integer c = 500;
        Integer d = 500;
        System.out.print(a == b);
        System.out.print(c == d);
    }
}
