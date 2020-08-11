package com.itcat;

import java.util.Arrays;
import java.util.Scanner;

/**
 * JZ49-将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 *      输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 *      如果是合法的数值表达则返回该数字，否则返回0
 *
 * 输入:
 *      +2147483647
 *      1a33
 * 输出:
 *      2147483647
 *      0
 */
public class TestStringToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个字符串：");
        String str = sc.nextLine();

        System.out.println(toInt(str));
    }
    //StringToInt
    public static int toInt(String str){
        if (str.equals("")) return 0;
        char[] ch = str.toCharArray();
        int flag = 0;
        if(ch[0] == '-'){
            flag = 1;
        }
        int temp = 0;
        for (int i = flag; i < ch.length; i++) {
            if(ch[i] == '+'){
                continue;
            }
            if(ch[i] >= 48 && ch[i] <= 57){
                temp = temp * 10 + ch[i] - 48;
            }else {
                return 0;
            }
        }
        return flag == 0 ? temp : temp * (-1);
    }
}
