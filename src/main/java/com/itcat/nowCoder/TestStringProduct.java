package com.itcat.nowCoder;

import java.util.Scanner;

/**
 * 计算字符串的乘积，不用任何库函数
 */
public class TestStringProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a string for str1:");
        String str1 = sc.nextLine();
        System.out.println("Input a string for str2:");
        String str2 = sc.nextLine();
        System.out.println("Output a product of str1 and str2:");
        System.out.print(getStringProduct(str1, str2));
    }
    //计算字符串的乘积
    public static String getStringProduct(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        if(str1 == null || len1 == 0 || str2 == null || len2 == 0){
            return "";
        }
        StringBuilder str = new StringBuilder();
        int[] arr = new int[len1+len2];
        for (int i = len1-1; i >= 0; i--) {//字符串乘积放入数组
            for (int j = len2-1; j >= 0; j--) {
                int ch1 = str1.charAt(i) - '0';
                int ch2 = str2.charAt(j) - '0';
                arr[i+j+1] += ch1*ch2;
            }
        }
        for (int i = arr.length-1; i > 0; i--) {//统一进位
            int num = arr[i]/10;
            int mod = arr[i]%10;
            arr[i] = mod;
            arr[i-1] += num;
        }
        int flag = 0;
        if(arr[0] == 0){//判断第一个元素是否为0，若为0这说明长度没用完
            flag = 1;
        }
        for (int i = flag; i < arr.length; i++) {//拼接字符串
            str.append(arr[i]);
        }
        return str.toString();
    }
}
