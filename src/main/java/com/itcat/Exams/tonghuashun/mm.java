package com.itcat.Exams.tonghuashun;

import java.util.Scanner;

/**
 *
 */
public class mm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);
        getNum(str,ch);
    }
    public static void getNum(String str,char ch){
        if (str.length() == 0|| str.matches(".*\\d{1,}.*") || str.matches(".*[~!_@#$%^&*\\.?]{1,}.*")){
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.toString(ch).equalsIgnoreCase(Character.toString(str.charAt(i)))) count++;
        }
        System.out.println(count);
    }
}
