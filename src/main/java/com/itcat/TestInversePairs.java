package com.itcat;

import java.util.Arrays;

/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class TestInversePairs {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,0};
        int[] arr = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,
                418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,
                557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,
                82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,
                433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(inversePairs(arr));
//        System.out.println(Arrays.toString(inversePairs1(arr)));
    }
    //逆序对数值总数取模，时间复杂度O(n^2)，空间复杂度为O(1)
    public static int inversePairs(int[] array){
        if(array.length == 0 || array == null) return 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) sum += 1;
            }
        }
        return sum % 1000000007;
    }

    //利用归并排序求逆序对
    public static int[] inversePairs1(int[] array){
        int[] arrs = Arrays.copyOf(array,array.length);
        if(arrs.length < 2){
            return arrs;
        }
        int mid = arrs.length/2;
        int[] left = Arrays.copyOfRange(arrs,0,mid);
        int[] right = Arrays.copyOfRange(arrs,mid,arrs.length);
        return merge(inversePairs1(left),inversePairs1(right));
    }
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}
