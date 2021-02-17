package com.itcat.tonghuahsun;

import java.util.Scanner;

public class Example {
    String str = new String("good");
    char[] ch = {'a','b','c'};
    public static void main(String[] args) {
        Example ex = new Example();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str+" and ");
        System.out.println(ex.ch);
    }
    public static void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'g';
        int[] arr = {0,1,0,3,12};
        Solution.moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        ///////
        String strs = "ths/1.10.22";
        System.out.println(strs.split("/")[1]);
        Solution.cc();
        System.out.println("========================");
        Solution.print1ToMaxOfNDigits(2);
    }
}
class Solution {
    public static void moveZeroes(int[] nums) {
        int zeroNum=0;//用来计算0的个数
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){//如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            }else if(zeroNum!=0){//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i-zeroNum]=nums[i];
                nums[i]=0;
            }
        }
    }
    public static void cc() {
        int number = (int) (Math.random() * (999 - 0 + 1) + 0);
        boolean flag = false;//flag 用于判定 默认没有包含
        int number2 = number;//number2是number的备份
        int low;
        do {
            low = number2 % 10;//获得最低位
            if (low == 5) {
                flag = true;
            }
            number2 /= 10;//去掉已经判断的最低位
        } while (number2 != 0);
        if (flag == true) {
            System.out.println("随机的数是：" + number + "包含5！");
        } else {
            System.out.println("随机的数是：" + number + "不包含5！");
        }
    }
    //
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    private static void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    private static void printNumber(char[] number) {
        boolean isBegin0 = true;
        int length = number.length;
        for (int i = 0; i < length; i++) {
            if (isBegin0 && number[i] != '0') {
                isBegin0 = false;
            }
            if (!isBegin0) {
                System.out.print(number[i]);
            }
        }
        if (!isBegin0) {
            System.out.println();
        }
    }
}
