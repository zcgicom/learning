package com.itcat.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class TestInsertSort {
    public static void main(String[] args) {
        int[] list = {9,6,1,3,5,67,3,2};
        int[] list1 = {9,6,1,3,5,67,3,2};
        insertSort(list);
        System.out.println(Arrays.toString(list));
        insertSort1(list1);
        System.out.println(Arrays.toString(list1));
    }
    //插入排序
    public static void insertSort(int[] list){
        if(list.length == 0){
            return;
        }
        int j = 1;
        for (int i = 0; i <list.length; i++) {
            if (j < list.length){
                for (int k = j; k > 0 ; k--) {
                    if(list[k - 1] > list[k] ){
                        swap(list,k - 1,k);
                    }
                }
            }
            j++;
        }
    }
    //插入排序
    public static void insertSort1(int[] list){
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if(list[j - 1] > list[j]){
                    swap(list,j-1,j);
                }
            }
        }
    }
    //交换
    public static void swap(int[] arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
