package com.itcat.xc;


import java.util.Arrays;

public class Main extends Alpha {
    public static void main(String[] args) {
        int[] a = {10,20,8,25,35,6,18,30,5,15,28};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        // 希尔排序
        int d = 5;
        while (true) {
            for (int i = 0; i < d; i++) {
                for (int j = i; j + d < a.length; j += d) {
                    int temp;
                    if (a[j] > a[j + d]) {
                        temp = a[j];
                        a[j] = a[j + d];
                        a[j + d] = temp;
                    }
                }
            }
            if (d == 1) {
                break;
            }
            d--;
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        int[] res = sort(a);//选择排序
        System.out.println();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

        int[] res1 = xiSort(a);//希尔排序
        System.out.println();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res1[i] + " ");
        }
    }

    //选择排序
    public static int[] sort(int[] arr){
        int[] res = Arrays.copyOf(arr,arr.length);
        int len = res.length;
        if(len == 0) return res;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i+1; j < len; j++) {
                if(res[j] < res[min]){
                    min = j;
                }
            }
            if (i != min){
                int temp = res[i];
                res[i] = res[min];
                res[min] = temp;
            }
        }
        return res;
    }
    //希尔排序
    public static int[] xiSort(int[] arr){
        int[] res = Arrays.copyOf(arr,arr.length);
        int len = res.length;
        if (len == 0)return res;
        for (int i = len/2; i > 0 ; i/=2) {
            for (int j = i; j < len; j++) {
                for (int k = j-i; k >= 0; k-=i) {
                    if (res[k] > res[k+i]){
                        int temp = res[k];
                        res[k] = res[k+i];
                        res[k+i] = temp;
                    }
                }
            }
        }
        return res;
    }
}
