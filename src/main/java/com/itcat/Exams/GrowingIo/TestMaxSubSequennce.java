package com.itcat.Exams.GrowingIo;

/**
 * 最长子序列
 * 10,9,2,5,4,3,7,101,18
 */
public class TestMaxSubSequennce {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,4,3,7,101,18};
        System.out.println(lengthOfLIS(arr)+" "+MaxSubSequennce(arr));
    }

    public static int MaxSubSequennce(int[] arr){
        if (arr.length == 0||arr == null)return 0;
        int maxLength = 0;
        int count = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int j = i+1;
            while (j < len){
                if(arr[i] < arr[j]&&arr[j-1] < arr[j]){
                    count++;
                }else {
                    if (count > maxLength){
                        maxLength = count;
                    }
                    count = 2;
                }
                j++;
            }
        }
        return maxLength;
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] a = new int[nums.length];
        a[0]=1;
        int max = 1;
        for(int i=1;i<nums.length;i++) {
            a[i] = 1;
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j] && a[i]<=a[j]) a[i] = a[j]+1;
            }
            if(a[i]>max) max=a[i];
        }
        return max;
    }
}
