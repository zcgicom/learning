package com.itcat.nowCoder;

import java.util.Scanner;

/**
 *  题目：    -整数求和(动态规划0-1背包模式)
 * 给定整数n，取若干个1到n的整数可求和等于整数m，编程求出所有组合的个数。比如当n=6，m=8时，
 * 有四种组合：[2,6], [3,5], [1,2,5], [1,3,4]。限定n和m小于120。
 */
public class TestDpSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a number as m:");
        int m = sc.nextInt();
        System.out.println("Input a number as n:");
        int n = sc.nextInt();
        getSum(m,n);
    }
    //动态规划求和
    public static void getSum(int m,int n){
        int[][] dp = new int[n+1][m+1];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (j < i){
                    dp[i][j] = dp[i - 1][j];
                }
                else if (j == i){
                    dp[i][j] = dp[i - 1][j] + 1;
                }
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - i];
                }
            }
        }
        System.out.println("The nums of combinations:");
        System.out.println(dp[n][m]);
    }
}
