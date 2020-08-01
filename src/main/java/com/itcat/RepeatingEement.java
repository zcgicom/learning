package com.itcat;

import java.util.LinkedList;

/**
 * 数组元素查询
 */
public class RepeatingEement {
    public static void main(String[] args) {
        int [] numbers = {2,3,1,0,2,5,3};
        int length = numbers.length;
        LinkedList<Integer> list = new LinkedList<Integer>();

        if(numbers == null||length<=0){
            System.out.println(list);;
        }

        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(numbers[i] == numbers[j]){
                    list.add(numbers[i]);
                }
            }
        }
        //打印出数组中所有重复元素
        System.out.println(list);
        //打印出数组中第一个出现的重复元素
        System.out.println(list.getFirst());
        //打印出数组中最后一个出现的重复元素
        System.out.println(list.getLast());
    }
}
