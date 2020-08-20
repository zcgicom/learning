package com.itcat;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示！
 */
public class TestIntToBinary {
    public static void main(String[] args) {
        System.out.println(getNum1(-5));
        System.out.println(getNum2(-5));
    }
    //位运算
    public static int getNum1(int num){
        int index = 1;
        int sum = 0;
        while (index != 0){
            if((index & num) != 0)sum++;
            index = index<<1;
        }
        return sum;
    }
    //遍历
    public static int getNum2(int num){
        char[] arr = Integer.toBinaryString(num).toCharArray();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if ('1' == arr[i]) sum++;
        }
        return sum;
    }
}
