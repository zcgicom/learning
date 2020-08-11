package com.itcat;

import java.util.Scanner;

/**
 * JZ-43 左旋转字符串
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class TestStringROL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个字符串：");
        String str = sc.nextLine();
        System.out.println("输入循环左移(ROL)的位数：");
        int n = sc.nextInt();
        System.out.println(LeftRotateString(str,n));
    }
    //左旋转字符串
    public static String LeftRotateString(String str,int n){
        if (n > str.length()) return "";
        String str1 = str.substring(0,n);
        String str2 = str.substring(n);
        String str3 = str2 + str1;
        return str3;
    }
}
