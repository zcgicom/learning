package com.itcat.Exams.tonghuashun;

import java.util.Arrays;
import java.util.Scanner;

public class TopK {

    public static int[] getLargestNumbers(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        Arrays.sort(nums);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {3,2,1,7,4};
        int k = sc.nextInt();
        System.out.println(getLargestNumbers(arr,k).toString());
    }

}