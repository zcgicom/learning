package com.itcat.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class TestSelectSort {
    public static void main(String[] args) {
        int[] array = {2,3,1,5,17,0,4,9,11,34,87,6,4};
        int len = array.length;
        //遍历
        selectSort(array,len);
        System.out.println(Arrays.toString(array));
        //递归
        selectSort1(array,0);
        System.out.println(Arrays.toString(array));
    }
    //遍历实现
    public static void selectSort(int[] array,int len){
        if(len > 1){
            for (int i = 0; i < len; i++) {
                int minIndex = i;
                for (int j = i+1; j < len; j++) {
                    if(array[minIndex] > array[j]){
                        minIndex = j;
                    }
                }
                swap(array,minIndex,i);
            }
        }
    }
    //递归selectSort1(array,0)
    public static void selectSort1(int[] array,int left){
        if(left < array.length){
            int minIndex = left;
            for (int i = left; i < array.length; i++) {
                if(array[left] > array[i]){
                    minIndex = i;
                }
            }
            swap(array,minIndex,left);
            selectSort1(array,left+1);
        }
    }
    //交换
    public static void swap(int[] array, int i, int j){
        int temp;
        temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
