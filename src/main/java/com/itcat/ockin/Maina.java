package com.itcat.ockin;

public class Maina {
    public static int search (int[] nums, int target) {
        // write code here
        if (nums.length == 0) return -1;
        int head = 0;
        int tail = nums.length - 1;
        int mid;
        while (head <= tail){
            mid = (head + tail)/2;
            if(nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                head = mid+1;
            }else {
                tail = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int ta = 1;
        System.out.println(search(nums,ta));
        System.out.println(twoSearch(nums,ta));
    }

    public static int twoSearch(int[] num,int tar){
        int left = 0;
        int right = num.length - 1;
        int mid = 0;
        while (left < right){
            mid = left + (right - left)/2;
            if(num[mid] < tar){
                left = mid + 1;
            }else if(num[mid] > tar){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
