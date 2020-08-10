package com.itcat.netease;

import java.util.Scanner;

/**
 * 小易去拜访朋友，他家在0点，朋友家在x点(x>0)，均在一条线上。小易可以一次向前走1，2,3,4或5步，问小易至少走多少次可以到朋友家？
 */
public class TestStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个大于0的数：");
        int x = sc.nextInt();
        System.out.println(getStep(x));
    }

    public static int getStep(int x){
        int a = x%5;
        int b = x/5;
        if(a == 0){
            return b;
        }else {
            return b+1;
        }
    }
}
