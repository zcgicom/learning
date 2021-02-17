package com.itcat.Exams.gbit;

import java.util.Scanner;

public class Maincc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        char c1 = sc.next().toLowerCase().charAt(0);
        char c2 = sc.next().toLowerCase().charAt(0);
        System.out.println(getCl(str,c1,c2));
    }
    public static int getCl(String str,char a,char b){
        if(str.length() == 0|| str == null||str.length() > 64){
            return -1;
        }
        int in = 0;
        int i1 = -1;
        int i2 = -1;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a){
                i1 = i;
                for (int j = i; j <str.length(); j++) {
                    if(str.charAt(j) == b)i2 = j;
                    if (i2 != -1&& i1 != -1) in = Math.abs(i2 - i1);
                    if (in > max){
                        max = in;
                    }
                }
                break;
            }
            if (str.charAt(i) == b){
                i2 = i;
                for (int j = i; j <str.length(); j++) {
                    if(str.charAt(j) == a)i1 = j;
                    if (i2 != -1&& i1 != -1) in = Math.abs(i2 - i1);
                    if (in > max){
                        max = in;
                    }
                }
                break;
            }
        }
        return (i1 == -1||i2 == -1) ? -1:max;
    }
}
