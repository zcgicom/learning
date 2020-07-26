package com.itcat;

/**
 * 整数的二进制中包含有多少个1
 */
public class TestIntToBinary {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(NumberOf1(n));
    }
    //
    public static int NumberOf1(int n) {
        char [] in = Integer.toBinaryString(n).toCharArray();
        int t=0;
        for(int i=0;i<in.length;i++){
            if(in[i] == '1'){
                t++;
            }
        }
        return t;
    }
}
