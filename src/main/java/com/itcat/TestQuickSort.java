package com.itcat;

import java.util.Arrays;

/**
 * 快速排序算法
 */
public class TestQuickSort {
    public static void main(String[] args) {
        int[] array = {2,3,1,5,7,0,4,9,11,34,87,6,4};
        int left = 0;
        int right = array.length - 1;
//        quickSort(array,left,right);
        quick(array,left,right);
        System.out.println(Arrays.toString(array));
    }

    //快速排序
    public static void quickSort(int[] array, int left, int right){
        if(left >= right){
            return ;
        }
        int i,j,temp;
        i=left;
        j=right;
        //temp就是基准位
        temp = array[left];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=array[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=array[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                swap(array,i,j);
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        array[left] = array[i];
        array[i] = temp;
        //递归调用左半数组
        quickSort(array, left, j-1);//此时i = j
        //递归调用右半数组
        quickSort(array, j+1, right);

    }
    //
    public static void quick(int[] arr, int left, int high){
        if(left >= high){return;}
        int i = left;
        int j = high;
        int pivod = arr[left];
        while (i  < j){
            while (i<j && pivod<=arr[j]) j--;
            while (i<j && pivod>=arr[i]) i++;
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,i,left);
        quick(arr,left,i-1);
        quick(arr,i+1,high);
    }
    //交换
    public static void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
