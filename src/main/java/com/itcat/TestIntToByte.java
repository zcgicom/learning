package com.itcat;

/**
 * 十进制整数转换为byte类型
 * 140对应二进制数为：      1   0  0   0 0 0 0 1
 * 对应的byte二进制数为：   1   0  0   0 1 1 0 0
 *                          128 64 32 16 8 4 2 1
 */
public class TestIntToByte {
    public static void main(String[] args) {
        byte b = (byte) 140;
        System.out.println(b);//-116
    }
}
