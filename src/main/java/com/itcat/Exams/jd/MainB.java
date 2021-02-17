package com.itcat.Exams.jd;

import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(call(n));
    }
    public static int call(int n){
        int x = 1;
        int sum =0;
        while (sum< n){
            x += 3;
            sum += x;
        }
        int pre = sum - x;
        int size = (int)(Math.log(x)/Math.log(3));
        char[] rem = new char[size];
        int res = n - pre;
        int a = x/3;
        for (int i = 0; i < size; i++) {
            int tq=(int)Math.pow(3,a);
            if(res/tq == 0)rem[i] = '3';
            else if (res/tq == 1) rem[i] = '3';
            else rem[i] = '5';
            a--;
        }
        String str = new String(rem);
        return Integer.parseInt(str);
    }
}
