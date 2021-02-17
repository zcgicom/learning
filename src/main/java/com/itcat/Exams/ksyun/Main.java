package com.itcat.Exams.ksyun;

import java.util.Scanner;

public class Main {
    public static int num5(int n){
        if (n < 5) return 0;
        int num = 0;
        String str = "";
        for (int i = 5; i <= n; i++) {
            str = Integer.toString(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) - '5' == 0)num++;
            }
        }
        return num;
//        int num = 0;
//        for (long i = 1; i <= n; i*=10) {
//            long tq = n/i;
//            long tr = n%i;
//            num += (tr+8)/10*i+(tr%10 == 1?tr+1:0);
//        }
//        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(num5(sc.nextInt()));
    }
}
