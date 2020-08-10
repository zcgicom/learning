package com.itcat.netease;

import java.util.Scanner;

/**
 *输入一个整型数组(可能有正数和负数)，求数组中连续子数组(至少有一个)的最大和，要求时间复杂度为O(n).
 * 输入描述：
 *      第一行为数组的长度N(N>=1)
 *      接下来N行，每行一个数，表示数组的N个元素
 * 输出描述：
 *      最大和的结果
 */
public class TestGreedyAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数组长度N：");
        int N = sc.nextInt();
        int[] res = new int[N];
        System.out.println("输入N个元素(各元素之间用空格隔开)：");
        for (int i = 0; i < N; i++) {
            res[i] = sc.nextInt();
        }
        System.out.println(getGreedy(res));
    }

    public static int getGreedy(int[] res){
        int max = res[0];
        int sum = 0;
        int low = 0;
        int high = 0;
        for (int i = 0; i < res.length; i++) {
            sum = sum + res[i];
            high += 1;//该语句用于找出子数组最大和的结束索引位置(如果需要找出最大和的子数组元素值)
            if(sum > max){
                max = sum;
            }
            if(sum < 0){//去除sum为负数的情况
                low = high;//该指令用于找出子数组最大和的开始索引位置
                sum = 0;
            }
        }
        for (int i = low; i < high; i++) {//打印出最大和的各个子元素值
            System.out.print(res[i]+" ");
        }
        return max;
    }
}
