package com.itcat;

import java.util.Arrays;

/**
 * 调换数组中奇数和偶数的位置，使所有奇数在前，偶数在后，并不改变元素相对位置
 */
public class TestReOrderArray {
    public static void main(String[] args) {
        int[] array = {2,3,1,5,7,0,4,9,11,34,87};
        reOrderArray1(array);
        reOrderArray2(array);
    }
    //
    public static void reOrderArray1(int [] array) {
        int t = 0;
        int[] list = new int[array.length];
        if(array.length == 0||array == null){
            System.out.println(Arrays.toString(array));
        }
        for(int i=0;i<array.length;i++){
            list[i] = array[i];
        }
        for (int i = 0; i < list.length; i++) {
            if(list[i]%2 != 0){
                array[t] = list[i];
                t++;
            }
        }
        for (int i = 0; i < list.length; i++) {
            if(list[i]%2 == 0){
                array[t] = list[i];
                t++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    //省去一次遍历
    public static void reOrderArray2(int [] array) {
        int pre = 0;
        int col = array.length - 1;
        int[] list = new int[array.length];
        if(array.length == 0||array == null){
            System.out.println(Arrays.toString(array));
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 != 0){
                list[pre] = array[i];
                pre++;
            }else {
                list[col] = array[i];
                col--;
            }
        }
        col = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if(list[i]%2 != 0){
                array[i] = list[i];
            }else {
                array[i] = list[col];
                col--;
            }

        }
        System.out.println(Arrays.toString(array));
    }
}
