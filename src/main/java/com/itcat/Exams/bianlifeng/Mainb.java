package com.itcat.Exams.bianlifeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mainb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        numOf(n,k);
    }

    public static void numOf(int n,int k){
        if (n == 0||n == 1) System.out.println(n);
        int[][] sum = new int[n+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            sum[i][1] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 2; j < i + 1; j++) {
                sum[i][j] = sum[i-1][j-1] + sum[i-j][j];
            }
            int temp = 0;
            for (int j = 1; j < n + 1; j++) {
                temp += sum[n][j];
                if (temp != 1){
                    System.out.println(temp);
                    break;
                }
            }
        }
    }
}
