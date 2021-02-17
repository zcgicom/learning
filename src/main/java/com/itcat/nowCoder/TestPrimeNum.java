package com.itcat.nowCoder;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数。
 *
 * 基本判断思路:
 *      在一般领域，对正整数n，如果用2到sqrt(n)之间的所有整数去除，均无法整除，则n为质数。
 *      质数大于等于2不能被它本身和1以外的数整除
 */
public class TestPrimeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个正整数：");
        int n = sc.nextInt();
        System.out.println(isPrime(n));
    }
    //判断是否为素数
    public static boolean isPrime(int num){
        if(num <= 3){
            return num>1;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
