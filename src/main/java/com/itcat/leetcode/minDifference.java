package com.itcat.leetcode;

import java.util.Arrays;
/**
 * 给你一个数组 nums ，每次操作你可以选择 nums 中的任意一个数字并将它改成任意值。
 *
 * 请你返回三次操作后， nums 中最大值与最小值的差的最小值。
 * 这里有一个问题就是，我只能改三次，如果改的话，肯定是把最大的改小了，或者把最小的改大了
 * 我们先排个序，改的三次不是在头就是在尾，我们用后四个分别减去前四个，
 * 求出最小的，那其他三个就是比较大的，改的时候改那三个就可以了
 *
 * 示例 1：
 * 输入：nums = [5,3,2,4]
 * 输出：0
 * 解释：将数组 [5,3,2,4] 变成 [2,2,2,2].
 * 最大值与最小值的差为 2-2 = 0 。
 *
 * 示例 2：
 * 输入：nums = [1,5,0,10,14]
 * 输出：1
 * 解释：将数组 [1,5,0,10,14] 变成 [1,1,0,1,1] 。
 * 最大值与最小值的差为 1-0 = 1 。
 */
public class minDifference {
    public static void main(String[] args) {
        int[] nums = {1,5,0,10,14};
        System.out.println(minDifference(nums));
    }
    public static int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //如果不到四个元素，证明把其他三个全换成和另一个一样的就可以了，结果就为0了
        if (n <= 4) {
            return 0;
        }
        System.out.println(nums[0]+" "+(n-2));
        return Math.min(Math.min(nums[n - 1] - nums[3], nums[n - 2] - nums[2]), Math.min(nums[n - 3] - nums[1], nums[n - 4] - nums[0]));
    }
}
