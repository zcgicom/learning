package com.itcat;

import java.util.*;


/**
 * 问题描述:长度为n的顺序表L，编写一个时间复杂度为O(n),空间复杂度为O(1)的算法，该算法删除线性表中所有值为x的数据元素。
 *
 * 解决思想：
 *    这个问题一个复杂的解决方法是依次遍历顺序表，遇到值为x的元素就删除，直到顺序表遍历完。这种解决方法的时间复杂度为O(n*n)，不满足题意。
 *    以下有两种解决方案：
 *   (1)用count记录顺序表中值不等于x的元素个数，边遍历顺序表L边记录count的个数，遍历时当元素当前位置的值不等于x时，向前移动到count的位置，
 *   遍历完成后修改顺序表L的长度。
 *   (2)用count记录顺序表中值等于x的元素个数，边遍历顺序表L边记录count的个数，遍历时当元素当前位置的值不等于x时，向前移动count个位置，
 *   遍历完成后修改顺序表L的长度。
 */
public class tableDel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个正整数n，表示序列长度：");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        System.out.println("输入一个序列，序列之间用空格隔开：");
        for (int i = 0; i < n; i++) {
            int tq = sc.nextInt();
            list.add(tq);
            list1.add(tq);
        }
        System.out.println("输入要删除的元素值：");
        int x = sc.nextInt();
        System.out.println(tableDelete(list, x));//ArrayList
        System.out.println(tableDelete1(list1, x));//LinkedList
    }
    //顺序删除值为x的元素，ArrayList时间复杂度为O(n)，空间复杂度为O(n)
    public static ArrayList<Integer> tableDelete(ArrayList<Integer> list, int x){
        if(list.isEmpty()){
            return list;
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(x)){
                list.remove(i);
            }
        }
        return list;
    }
    //顺序删除值为x的元素，时间复杂度为O(n)，空间复杂度为O(1)
    public static LinkedList<Integer> tableDelete1(LinkedList<Integer> list, int x){
        if(list.isEmpty()){
            return list;
        }
        int count = 0;
        while (list.size() != count){
            if(list.get(count) == x){
                list.remove(count);
            }
            count++;
        }
        return list;
    }
}
