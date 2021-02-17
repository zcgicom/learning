package com.itcat;

import java.util.Scanner;

/**
 * 2
 * 3 5
 * 4 1
 * 5 1
 * 7 7
 * 2 1
 * 2 2
 * 4 0
 * case:
 * 3 4
 * 0 0
 */
public class Maina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n*t][2];
        for (int j = 0; j < n*t; j++) {
            arr[j][0] = sc.nextInt();
            arr[j][1] = sc.nextInt();
//            System.out.println("###"+arr[j][0]+" "+arr[j][1]);
        }
        int[][] res = getNum(arr,n,m,t);
        for (int i = 0; i < t; i++) {
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
    public static int[][] getNum(int[][] arr,int n,int m,int t){
        int[][] res = new int[t][2];
        if(arr.length == 0)return res;
        int lev = 0;
        int count = 0;
        int index = 0;
        int tq = 0;
        int temp = n;
        while (index != t){
            for (int i = tq; i < n; i++) {
                if (m >= arr[i][0]){
                    count++;
                    n--;
                    lev = arr[i][0];
                    m -= arr[i][0];
                    if(n != 0){
                        if(arr[i][1]>n){
                            count += n;
                        }else {
                            count += arr[i][1];
                            n -= arr[i][1];
                        }
                    }
                }else {
                    res[index][0] = count;
                    res[index][1] = lev;
                    break;
                }
            }
            tq = temp;
            n = 2*tq;
            index++;
        }
        return res;
    }
}
