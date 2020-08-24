package com.itcat;

import java.util.Scanner;

/**
 * 输入分数字符串，实现分数四则运算
 * 输入：
 *      a/b o c/d       -- a,d,c,d为“1~9”之间的数，o为“+ - * /”中的一个运算
 * 输出：
 *      分数的最简形式
 */
public class TestArithmeticString {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        String res = solution(str);
    }

    public static String solution(String string) {
        // 拿到运算式中的每个字符
        int f1 = string.charAt(0)-'0';
        int m1 = string.charAt(2)-'0';
        char y = string.charAt(4);
        int f2 = string.charAt(6)-'0';
        int m2 = string.charAt(8)-'0';
        String res = "";
        // 具体的运算方法
        switch (y) {
            case '+':
                res = add(f1, m1, f2, m2);
            break;
            case '-':
                res = sub(f1, m1, f2, m2);
                break;
            case '*':
                res = multilp(f1, m1, f2, m2);
                break;
            case '/':
                res = dev(f1, m1, f2, m2);
                break;
        }
        res = format(res);
        return res;
    }

    // 化简
    public static String format(String s) {
        int f = Integer.parseInt(s.split("/")[0]);
        int m = Integer.parseInt(s.split("/")[1]);
        int cd = getCD(f, m);
        f = f / cd;
        m = m / cd;
        return f + "/" + m;
    }

    public static String add(int f1, int m1, int f2, int m2) {
        int f = f1 * m2 + f2 * m1;
        int m = m1 * m2;
        return f + "/" + m;
    }
    public static String sub(int f1, int m1, int f2, int m2) {
        int f = f1 * m2 - f2 * m1;
        int m = m1 * m2;
        return f + "/" + m;
    }
    public static String multilp(int f1, int m1, int f2, int m2) {
        int f = f1 * f2;
        int m = m1 * m2;
        return f + "/" + m;
    }
    public static String dev(int f1, int m1, int f2, int m2) {
        return multilp(f1, m1, m2, f2);
    }


    // 求最大公约数
    public static int getCD(int n1,int n2){
        while (n2 != 0){
            int mod = n1 % n2;
            n1 = n2;
            n2 = mod;
        }
        return n1;
    }
}
