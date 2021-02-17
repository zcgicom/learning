package com.itcat.Exams.netease;

import java.util.Arrays;

public class dev7 {
    public static int maxSumDivSeven(int[] nums) {
        int ans = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        Arrays.sort(nums);
        if (sum % 7 == 0) return sum;
        for (int i = 0; i < nums.length; i++) {
            if ((sum - nums[i]) % 7 == 0) ans = Math.max(ans, sum - nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if ((sum - nums[i] - nums[j]) % 7 == 0) {
                    ans = Math.max(ans, sum - nums[i] - nums[j]);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7,3,1,4};
        System.out.println(maxSumDivSeven(arr));
    }
}
