package com.itcat.Exams.ksyun;

import java.util.Scanner;

public class Maina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        int[][] arr = new int[T][str.length];
        boolean flag = true;
        if (T == 1) flag = false;
        else T = T - 1;
        for (int i = 0; i < T; i++) {
            if (flag) str = sc.nextLine().split(" ");
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
//        isEquals(arr);
        getSum(arr);
    }
    public static void isEquals(int[][] arr){
        if (arr.length == 0||arr[0].length == 0) System.out.println("Yes");
        for (int i = 0; i < arr.length; i++) {
            int lq = arr[i][1];
            int rq = arr[i][2];
            int count = 1;
            if (arr[i].length == 1){
                System.out.println("Yes");
                continue;
            }
            for (int j = 3; j < arr[i].length - 1; j=j+2) {
                if (count%2!=0)lq += arr[i][j] + arr[i][j+1];
                else rq += arr[i][j] + arr[i][j+1];
                count++;
            }
            if (lq == rq) System.out.println("Yes");
            else System.out.println("No");
        }
    }
    //递归求和
    public static int sum(int[][] arr,int col,int index){
        if (index < arr.length) return arr[col][index] + sum(arr,col,2*index+1) + sum(arr,col,2*index+2);
        else return 0;
    }
    //判断是否符合左权和等于右权和
    public static void getSum(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr[i].length / 2 - 1; j++) {
                if (sum(arr,i,2*i+1) == sum(arr,i,2*i+2)){
                    System.out.println("Yes");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) System.out.println("No");
        }
    }
}
