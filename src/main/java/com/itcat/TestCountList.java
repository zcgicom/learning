package com.itcat;

import java.util.Arrays;

/**
 * 找出数组中出现次数超过数组长度一半的元素
 */
public class TestCountList {
    public static void main(String[] args) {
        int[] list = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(list));
        System.out.println(getNum(list));
    }
    //取中间值方法，得到的中间值即是返回的元素(如果存在这样一个元素)
    public static int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count = 0;
        int mid = array[array.length / 2];
        for(int i=0;i<array.length;i++){
            if(mid == array[i]){
                count++;
            }
        }
        if(count>(array.length/2)){
            return mid;
        }
        return 0;
    }
    //遍历
    public static int getNum(int[] array){
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[array[i]]++;
        }
//        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>(array.length/2)) return i;
        }
        return 0;
    }
}
