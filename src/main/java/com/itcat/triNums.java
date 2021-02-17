package com.itcat;

import java.util.Scanner;

/**
 * 给定一个长度为N的数组A=[A1, A2, ... AN]。请求出有多少下标三元组(i, j, k)满足1 ≤ i < j < k ≤ N且Ai <= Aj <=Ak。
 */
public class triNums {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }

        System.out.println(getTriNums(arr));
    }

    public static int getTriNums(int[] arr){
        int num = 0;
        if (arr.length < 3)return num;
        int len = arr.length;
        for (int i = 1; i <= len-2; i++) {
            for (int j = i+1; j < len; j++) {
                if (arr[i] <= arr[j]){
                    for (int k = i-1; k >=0; k--) {
                        if (arr[k] <= arr[i]){
                            num++;
                            System.out.println(arr[k]+" "+arr[i]+" "+arr[j]);
                        }
                    }
                }
            }
        }
        return num;
    }
}
