package com.itcat.test;
import java.util.Scanner;
import java.lang.Math;

/**
 * 一个500以内的正数k，加a之后得到一个完全平方数，加b之后又得到一个完全平方数
 * 输入：
 *      100，200
 * 输出：
 *      476
 */
public class Main{
    public static void main(String[] args) {
        int[] arr = new int[2];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getNum(arr));
    }
    public static int getNum(int[] nums){
        if (nums.length == 0||nums == null){
            return 0;
        }
        int k = 0;
        for (int i = 1; i < 500; i++) {
//            int v1 = (int) Math.sqrt(i +nums[0]);
            int v1 = (int)Math.pow((i+nums[0]),0.5);
            int v2 = (int) Math.sqrt(i +nums[1]);
            if (v1 * v1 == i+nums[0]&&v2 * v2 == i+nums[1]){
                k = i;
            }
        }
        return k;
    }
}
