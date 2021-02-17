package com.itcat.Exams.exam360;

import java.util.Scanner;

public class Maina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String st = flip(str);
        System.out.print(st);
    }
    public static String flip(String str){
        if(str.charAt(0) == 'n'||str.length() == 0) return str;
        String strs = "";
        int len = str.length();
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == 'n'){
                String s = str.substring(temp+1,i);
                strs = strs + str.toUpperCase().charAt(temp) + s + "\n";
                temp = i;
            }
        }
        String s = str.substring(temp+1,len);
        strs = strs + str.toUpperCase().charAt(temp) + s;
        return strs;
    }
}
