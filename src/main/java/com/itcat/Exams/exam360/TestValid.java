package com.itcat.Exams.exam360;

import java.util.Scanner;

public class TestValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n分问卷
        String [] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        System.out.println(getNum(strs));
    }
    //
    public static int getNum(String[] strs){
        if(strs.length == 0|| strs == null) return 0;
        int sum = 0;
        boolean res = true;
        for (String str:strs) {
            res = isValid(str);
            if (res){
                sum++;
            }
        }
        return sum;
    }
    //
    public static boolean isValid(String str){
        if(str.length() > 10||str.length() == 0)return false;
        return str.matches("^[a-zA-Z]{1,10}$");
    }
}
