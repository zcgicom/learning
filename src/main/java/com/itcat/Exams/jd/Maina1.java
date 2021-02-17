package com.itcat.Exams.jd;

import java.util.Scanner;

/**
 * 滚雪球求最大和 - 动态规划
 */
public class Maina1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[n+1][2 * n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 2; j < 2 * i +1; j++) {
                dp[i][j]=sc.nextInt();
            }
        }

        int max=Integer.MIN_VALUE;
        for (int i = 1; i < n+1; i++) {
            for (int j = 2; j < 2 * n+1 ; j++) {

                dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i-1][j-2]), dp[i-1][j-1]) + dp[i][j];
                if (dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
