package com.itcat.shunwang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = {49,38,65,97,76,13,27,49};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int [] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            // 找出最小值得元素下标
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }
    }
}
