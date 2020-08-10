package com.itcat;

import java.security.PublicKey;
import java.util.Scanner;
import java.util.Stack;

/**
 * JZ21
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class TestStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("序列长度：");
        int len = sc.nextInt();
        System.out.println("输入一个序列，表示栈的压入顺序：");
        int[] list_push = new int[len];
        for (int i = 0; i < len; i++) {
            list_push[i] = sc.nextInt();
        }
        System.out.println("输入一个序列，表示栈的弹出顺序：");
        int[] list_pop = new int[len];
        for (int i = 0; i < len; i++) {
            list_pop[i] = sc.nextInt();
        }

        if (isEquals(list_push, list_pop)) {
            System.out.println("第二个序列是该栈的弹出顺序！");
        }else {
            System.out.println("第二个序列不是该栈的弹出顺序！");
        }
    }
    //判断
    public static boolean isEquals(int[] push, int[] pop){
        if(push.length == 0 || pop.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while (j < pop.length && stack.peek() == pop[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty()?true:false;
    }
}
