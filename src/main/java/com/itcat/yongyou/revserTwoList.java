package com.itcat.yongyou;

import java.util.Arrays;

/**
 * 翻转二维数组
 * [[1,2,3],[4,5,6],[7,8,9]]    -->     [[7,8,9],[4,5,6],[1,2,3]]
 */
public class revserTwoList {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        reverseList(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }

    }

    public static void reverseList(int[][] nums){
        if (nums.length == 0 || nums == null)return;
        int[] temp;
        for (int i = 0; i < nums.length/2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length-1 - i];
            nums[nums.length-1 - i] = temp;
        }
    }
}

