package com.itcat.nowCoder;

import java.util.Scanner;

/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class TestRectCover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(getTarget(target));//递归
        System.out.println(RectCover(target));
        System.out.println(rect(target));//动态规划
    }
    //递归实现，复杂度较高
    public static int getTarget(int target){
        if(target < 1) return 0;
        if(target == 1 || target == 2) return target;
        return getTarget(target - 1) + getTarget(target - 2);
    }
    //RectCover
    public static int RectCover(int target) {
        if(target < 1) return 0;
        int a = 0;
        int b = 1;
        int t = 1;
        while(target -- > 0){
            t = a + b;
            a = b;
            b = t;
        }
        return t;
    }
    //动态规划
    public static int rect(int target){
        if(target <= 2) return target;
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];
    }
}
