package com.itcat.Exams.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入T组测试数据，每组数据包含n个物品的价值，要求将该n个物品的价值分配给两个人使得其价值相等，并丢弃剩余无法分配的价值。
 *
 * 输入描述：
 *      第一行输入T为T组测试数据；
 *      第二行输入每组数据的长度为n个；
 *      第三行输入n个数据，要求每组数据分别打印出丢弃的价值
 * 输入描述：
 *      丢弃的价值总和
 *      如：输入为1
 *                5
 *                15 5 30 30 60
 *          输出为20(15+5)
 */
public class TestGreedyDiscard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入t:");
        int t = sc.nextInt();//输入T
        while (t-->0){
            System.out.println("输入n:");
            int n = sc.nextInt();
            int[] tq = new int[n];
            int sum = 0;
            System.out.println("输入n个数:");
            for (int i = 0; i < n; i++) {
                tq[i] = sc.nextInt();
                sum += tq[i];
            }

            int a = 0;
            int b = 0;
            Arrays.sort(tq);
            System.out.println(get(tq, a, b, sum));
        }
    }

    public static int get(int[] list,int a,int b,int sum){
        int min = 0;
        int index = 0;
        a += list[list.length-1];
        for (int i = list.length - 2; i >=0; i--) {
            if(a >= b){
                if(a == b){
                    if (index == list.length-1){
                        return min;
                    }else {
                        min = sum - (a+b);
                    }
                }else {
                    b += list[i];
                }
            }else {
                a += list[i];
            }
            index++;
        }
        return min;
    }
}
