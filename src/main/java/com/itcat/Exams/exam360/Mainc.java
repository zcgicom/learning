package com.itcat.Exams.exam360;

import java.util.Scanner;

public class Mainc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(panDuan(s));
    }
    public static boolean panDuan(String str) {
        if (str.length() == 0)return true;
        char[] tq = {'A','H','I','M','O','T','U','V','W','X','Y'};
        boolean flag = true;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            flag = isTure(str.charAt(i),tq);
            if (!flag){
                break;
            }
        }
        return flag;
    }
    public static boolean isTure(char ch,char[] arr){
        int len =arr.length;
        for (int i = 0; i < len; i++) {
            if(ch == arr[i]) return true;
        }
        return false;
    }
}
