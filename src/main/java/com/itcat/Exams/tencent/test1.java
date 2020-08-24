package com.itcat.Exams.tencent;

import java.util.Scanner;
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//T组数据
        int[] t_arr = new int[t];
        for (int i = 0; i < t; i++) {//每组一个数字n
            t_arr[i] = sc.nextInt();
        }
        int[] res = getMaxVal(t_arr);//返回最大值集合
        for (int tq:res) {
            System.out.print(tq+" ");//遍历集合
        }
    }
    public static int[] getMaxVal(int[] arr){
        if(arr.length == 0) return arr;//如果数组为空，则最大值集合为空
        int len = arr.length;
        int[] max = new int[len];//n组测试的最大值
        int a = 0;//拆分数字n得到a
        int b = 0;//拆分数字n得到b
        for (int i = 0; i < len; i++) {
            int temp = arr[i];//取出T组数据的第i个数字n
//            if (temp%2 == 0){//拆分数字n
//                a = temp/2;
//                b = a;
//            }else {
//                a = temp/2;
//                b = a + 1;
//            }
            a = 9;
            b = temp - a;
            if (temp < 10) max[i] = temp;//计算最大和
            else {
                String str_a = Integer.toString(a);
                int sum_a = 0;
                for (int j = 0; j < str_a.length(); j++) {
                    sum_a = sum_a + str_a.charAt(j) - '0';//计算S(a)得到的最大和
                }
                String str_b = Integer.toString(b);
                int sum_b = 0;
                for (int j = 0; j < str_b.length(); j++) {
                    sum_b = sum_b + str_b.charAt(j) - '0';//计算S(b)得到的最大和
                }
                max[i] = sum_a + sum_b;//保存第i个数字n最后拆分得到的最大Val
            }
        }
        return max;
    }

}
