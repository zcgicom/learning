package com.itcat.Exams.ctrip;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();
        System.out.println(buyCoke(m,a,b,c,x));
    }
    public static int buyCoke(int m,int a,int b,int c,int x){
        if (m == 0) return 0;
        int count = 0;
        while (m-- > 0){
            int temp = x;
            while (temp > 0){
                if (temp >= 10&&a > 0){
//                    System.out.println(temp);
                    count++;
                    if (temp >= 50&&b > 0){
                        if (temp >= 100&&c > 0){
                            c--;
                            temp = temp - 100;
                            System.out.println(temp);
                            if (temp >= 50&&temp < 100&&c > 0){
                                b++;
                                temp = 100 - temp;
                            }
                        }else {
                            b--;
                            temp = temp - 50;
                            System.out.println("ss"+temp);
                            if (temp >= 10&&temp < 50) a++;
                        }
                    }else {
                        a--;
                        temp = temp - 10;
                    }
                }
            }
        }
        return count;
    }
}
