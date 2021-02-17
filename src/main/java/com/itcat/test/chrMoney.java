package com.itcat.test;

import java.util.Scanner;

public class chrMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int[] moneys = {1, 4, 16, 64};
        System.out.println(getNum(moneys,money));
    }
    public static int getNum(int[] moneys,int money){
        int sum = 0;
        String str = "";
        int mod = 0;
        int dev = 0;
        for (int i = moneys.length - 1; i >=0; i--) {
            if (money >= moneys[i]){
                dev = money / moneys[i];
                mod = money % moneys[i];
                money = mod;
                sum += dev;
                if (mod > 0)str = str + "需要" + dev + "张" + moneys[i] + "块的\n";
                else {
                    str = str + "需要" + dev + "张" + moneys[i] + "块的";
                    break;
                }
            }
        }
        System.out.println(str);
        return sum;
    }
}
