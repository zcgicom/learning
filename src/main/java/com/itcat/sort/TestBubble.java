package com.itcat.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class TestBubble {
    public static void main(String[] args) {
        int[] array = {2,3,1,5,17,0,4,9,11,34,87,6,4};
        int len = array.length - 1;
        //遍历
        bubble(array);
        System.out.println(Arrays.toString(array));
        //递归
        bubble1(array,len);
        System.out.println(Arrays.toString(array));
    }

    //遍历实现
    public static void bubble(int[] array){
        int length = array.length - 1;
        if(length > 0 || array != null){
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    if(array[j] > array[j+1]){
                        int temp;
                        temp = array[j+1];
                        array[j+1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }
    //递归实现
    public static void bubble1(int[] array, int len){
        if(len - 1 > 0){
            for (int i = 0; i < len; i++) {
                if(array[i] > array[i+1]){
                    int temp;
                    temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                }
            }
            bubble1(array,len - 1);
        }
    }
}
