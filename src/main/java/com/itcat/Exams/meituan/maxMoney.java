package com.itcat.Exams.meituan;

import java.util.Scanner;

/**
 * 美团跑腿获得的钱最多
 */
public class maxMoney {
    public static void main(String[] args) {
//        int n = 5;//n个订单
//        int m = 2;//可以接取的订单
//        int[][] msg = {{5,10},{8,9},{1,4},{7,9},{6,10}};//{跑腿价格v，商品重量w}  2元/kg
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] msg = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                msg[i][j] = sc.nextInt();
            }
        }
        String str = getTask(msg,n,m);
        System.out.println(str);
    }
    //获得价值最大的订单，并返回订单编号
    public static String  getTask(int[][] msg,int n,int m){
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {//计算价值
            list[i] = msg[i][0] + msg[i][1] * 2;
        }
        String str = "";
        int max = 0;
        for (int i = 0; i < m; i++) {//找出价值最大的
            for (int j = 1; j < n; j++) {
                if(list[max] <= list[j]){
                    if (max == j)continue;
                    max = j;
                    break;
                }
            }
            if(i < m){
                str += max + 1 + " ";
            }else {
                str += max + 1;
            }
        }
        return str;//返回结果字符串
    }
}
