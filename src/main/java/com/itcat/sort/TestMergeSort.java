package com.itcat.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class TestMergeSort {
    public static void main(String[] args) {
        int[] list = {1,4,6,7,8,11,2,3,5,9,10};
        System.out.println(Arrays.toString(mergeSort(list)));
    }
    //merger sort
    public static int[] mergeSort(int[] list){
        int i = 0;
        int j = (list.length >> 1) + 1;//数组对半划分索引位置，即右半排序数组的开始位置
        int[] tq = new int[list.length];
        int le = j;
        for (int k = 0; k < tq.length; k++) {
            if(j >= list.length){//保持右边数组不会越界
                tq[k] = list[i];
            }else {
                if(list[i] < list[j] && i < le){//判断并保持左边数组不会越界
                    tq[k] = list[i];
                    i++;
                }else {
                    tq[k] = list[j];
                    j++;
                }
            }
        }
        return tq;
    }
}
