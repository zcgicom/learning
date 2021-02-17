package com.itcat.mix;

import java.util.Scanner;

public class Mainb {
    public static String  printString(String str){
        if (str == null||str.length() == 0) return str;
        StringBuilder sbString = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            int pre = str.indexOf(ch);
            int pos = str.lastIndexOf(ch);
            if (pre == pos||pre == i) sbString.append(ch);
        }
        return sbString.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println(printString(sc.next()));
    }
}
