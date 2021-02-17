package com.itcat.ockin;

/**
 * 2的幂次方
 */
public class Main {
    public static boolean isPowerOfTwo (int n) {
        // write code here
        double v = Math.log(n)/Math.log(2);
        System.out.println((int)v);
        if ((v-(int)v == 0))return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-1));
    }
}
