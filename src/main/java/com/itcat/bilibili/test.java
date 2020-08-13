package com.itcat.bilibili;

import java.util.Scanner;

/**
 * 贪心算法 - 钱币找零
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(GetCoinCount(N));
        System.out.println(getNum(N));
    }

    /**
     * 钱币找零问题
     */
    public static int GetCoinCount(int N) {
//        System.out.println("需要找零: " + money);
        if (N <= 0 || N > 1024){return 0;}
        int money = 1024 - N;
        int num = 0;
        int mod = 0;
        int sum = 0;
        int[] moneys = {1, 4, 16, 64};
        for (int i = moneys.length - 1; i >= 0; i--) {
            sum += money/ moneys[i];
            num = money/ moneys[i];
            mod = money % moneys[i];
            money = mod;
            if (num > 0) {
                System.out.println("需要" + num + "张" + moneys[i] + "块的");
            }
        }
        return sum;
    }
    public static int getNum(int N){
        if(N<0||N>1024) return 0;
        int mo = 1024 - N;
        int[] tq = {64,16,4,1};
        int sum = 0;
        for (int i = 0; i < tq.length; i++) {
            int num = mo/tq[i];
            int mod = mo%tq[i];
            mo = mod;
            sum += num;
        }
        return sum;
    }
}
