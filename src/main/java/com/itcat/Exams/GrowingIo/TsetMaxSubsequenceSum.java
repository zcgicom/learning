package com.itcat.Exams.GrowingIo;

/**
 * 求数组的最大连续子序列和
 */
public class TsetMaxSubsequenceSum {
    public static void main(String[] args) {
        int[] arr = {1,-1,3,-5,0,2,13};
        System.out.println(MaxSubsequenceSum(arr,arr.length));
    }
    public static int MaxSubsequenceSum(int a[], int n) {
        int thisSum, maxSum, i;
        thisSum = maxSum = 0;
        for ( i = 0; i < n; i++){
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
            else if (thisSum < 0) {
                thisSum = 0;//负数在求和中永远是累赘，出现负数即跳过，置零重新开始
            }
        }
        return maxSum;
    }
}
