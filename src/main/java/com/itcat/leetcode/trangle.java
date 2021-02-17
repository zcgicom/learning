package com.itcat.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 杨辉三角 -- LeetCode.118
 */
public class trangle {
    public static  List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for (int i=0;i<numRows;i++){
            ArrayList<Integer> sub=new ArrayList<Integer>();
            for (int j=0;j<=i;j++){
                //第一个位置和最后一个位置的元素为1
                if (j==0 || j==i){
                    sub.add(1);
                }else {
                    //上一行的元素进行相加
                    sub.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(sub);

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int numRows = sc.nextInt();
        List<List<Integer>> lists;
        lists = generate(numRows);
        for (List<Integer> in:lists) {
            for (Integer i:in) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
