package com.itcat.tiger;

import java.util.Scanner;

public class Tiger2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入单辆车的最大承载量(1<=capacity<=10000)：");
        int capacity = sc.nextInt();//一辆车最大承载量
        System.out.println("输入乘客组数(<=1000)：");
        int n = sc.nextInt();
        int[][] trips = new int[n][3];
        for (int i = 0; i < trips.length; i++) {
            for (int j = 0; j < 3; j++) {
                trips[i][j] = sc.nextInt();//第i组乘客信息
            }
        }
        System.out.println(getCar(trips,capacity));
    }
    //
    public static int getCar(int[][] trip,int cap){
        int temp = 0;
        for (int i = 0; i < trip.length-1; i++) {
            if(cap <= trip[i][0]){
                temp += 1;
            }else {
                if(cap%trip[i][0] == 0){
                    temp += cap/trip[i][0];
                }else {
                    temp += cap/trip[i][0] + 1;
                }
            }
            if(trip[i][0] < trip[i+1][0]){
                if (trip[i+1][0]%trip[i][0] != 0){
                    temp += trip[i+1][0]/trip[i][0] +1;
                }
            }
        }
        return temp;
    }
}
