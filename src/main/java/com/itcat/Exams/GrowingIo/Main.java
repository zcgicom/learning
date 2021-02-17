package com.itcat.Exams.GrowingIo;

import java.util.Scanner;

/**
 * 在array中查找是否存在一个目标值，若存在返回其位置，否则返回-1
 * 输入：-1 0 3 5 9 12     target = 9
 * 输出：4
 */
public class Main {
    public static void main(String[] args) {
        //标准输入
//        Scanner sc = new Scanner(System.in);
//        Solution ans = new Solution();
//        while (sc.hasNextLine()){
//            String[] targetLine = sc.nextLine().split(" ");
//            int[] targets = new int[targetLine.length];
//            for (int i = 0; i < targetLine.length; i++) {
//                targets[i] = Integer.parseInt(targetLine[i]);
//            }
//            int target = Integer.parseInt(sc.nextLine());
//            int out = ans.search(targets,target);
//            System.out.print(out+"\n");
//        }
        int[] arr = {-1,0,3,5,9,12 };
        int target = 5;
        System.out.println(Solution.find(arr,target));
    }
}
class Solution{
    public static int search(int[] nums,int target){//遍历
        int row = 0;
        int col = nums.length - 1;
        while(row < nums.length && col >= 0){
            int val = nums[row];
            if(target > val){
                row++;
            }else if(target < val){
                col--;
            }else{
                return row;
            }
        }
        return -1;
    }
    public static int find(int[] nums,int target){//二分查找
        if (nums == null||nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int mid = right - left /2;
            if(nums[mid] > target){
                right = mid - 1;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }
            if(nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }
    public static int search1(int n,int[] array){
        int low = 0;
        int high = array.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(array[mid]==n) return mid;
            if(array[mid]>array[low]){  //left is order
                if(n<=array[mid]&&n>=array[low]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else {
                if(n>=array[mid]&&n<=array[high]){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
