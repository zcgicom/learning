package com.itcat.Exams.mm;

import java.util.Scanner;

/**
 * 输入
 * 输入两个正整数m,n，m<=n<=12。计算C(m,n)的值
 *
 * 输出
 * 输出一个整数，即组合方案数。
 *
 * 输入
 * 2 3
 * 输出
 * 3
 */
public class Solution {
    public static int combination(int m, int n) {
        int ans1 = fac(m);
        int ans2 = fac(n-m);
        int ans3 = fac(n);
        return ans3 / ans1 /ans2;
    }
    public static int fac(int k){
        int sum = 1;
        for (int i = 2; i <= k; i++) {
            sum *= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println(combination(m,n));
    }
}
