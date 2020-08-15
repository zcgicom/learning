package com.itcat.Exams.ctrip;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestBlock {
    public static void main(String[] args) {
        int[] arr = divingBoard(100,1,3);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 铺砖
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static int[] divingBoard(int a, int b, int k) {
        if (k == 0){
            return new int[0];
        }
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i <= k >> 2; i++) {
            int res = (a * i) + (k - i) * b;
            set.add(res);
            int res1 = (b * i) + (k - i) * a;
            set.add(res1);
        }
        int size = set.size();
        int[] res = new int[size];
        int temp = 0;
        for (Integer i : set) {
            res[temp] = i;
            temp++;
        }
        return res;
    }
}
