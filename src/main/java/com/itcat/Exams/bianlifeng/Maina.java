package com.itcat.Exams.bianlifeng;

import java.util.Scanner;
import java.util.Stack;

public class Maina {
    static int count = 0;
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sum = new int[n];
        sum[0] = 1;
        for (int i = 1; i < n; i++) {
            sum[i] = i+sum[i-1];
        }
        makeSum(n,n,k,sum);
        System.out.println(count);
    }
    public static void makeSum(int index,int num,int k,int[] sum){
        if (num == 0){
            Stack<Integer> temp = stack;
            int target = 0;
            while (!temp.isEmpty()){
                temp.pop();
                target++;
            }
            if (target == k){
                count++;
            }
            return;
        }
        for (int i = index; i >=0&&num <= sum[i-1]; i--) {
            if (i<=num){
                stack.push(i);
                makeSum(i,num-i,k,sum);
                stack.pop();
            }
        }
    }
}
