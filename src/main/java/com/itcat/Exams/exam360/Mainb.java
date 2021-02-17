package com.itcat.Exams.exam360;

import java.util.Scanner;

public class Mainb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//m个英雄
        int n = sc.nextInt();//n件装备
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int tq = getMax(arr,m,n,0,0);
        System.out.println(tq);
    }
    public static int getMax(int[][] arr,int m,int n,int row,int col){
        if (arr.length == 0||arr == null) return 0;
        int max = 0;
        int temp = 0;
        while (row > m||col > n){
            temp = arr[row][col]+getMax(arr,m,n-1,row++,col++);
            if (temp > max) max = temp;
        }
        return max;
    }
}
