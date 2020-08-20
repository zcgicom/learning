package com.itcat.Exams.youzan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,3,4,4,};
        System.out.println(maxSumDivThree(arr));
    }
        /**
         *
         * @param nums int整型一维数组
         * @return int整型
         */
     public static int maxSumDivThree(int[] nums) {
         int sum = 0;
         int target = 5;
         List<Integer> one = new ArrayList<Integer>();
         List<Integer> two = new ArrayList<Integer>();
         Arrays.sort(nums);
         for(int n : nums){
             sum += n;
             if(n % target == 1)
                 one.add(n);
             if(n % target == 2)
                 two.add(n);
         }
         if(sum % target == 0)
             return sum;
         else if(sum % target == 1){
             if(one.size() > 0 && two.size() > 1){
                 int removeOne = one.get(0);
                 int removeTwo = two.get(0) + two.get(1);
                 sum -= Math.min(removeOne, removeTwo);
                 return sum;
             }else if(one.size() > 0){
                 return sum - one.get(0);
             }else if(two.size() > 1){
                 return sum - two.get(0) - two.get(1);
             }else{
                 return 0;
             }
         }
         else{
             if(two.size() > 0 && one.size() > 1){
                 int removeOne = two.get(0);
                 int removeTwo = one.get(0) + one.get(1);
                 sum -= Math.min(removeOne, removeTwo);
                 return sum;
             }else if(two.size() > 0){
                 return sum - two.get(0);
             }else if(one.size() > 1){
                 return sum - one.get(0) - one.get(1);
             }
             else{
                 return 0;
             }
         }
     }
}


