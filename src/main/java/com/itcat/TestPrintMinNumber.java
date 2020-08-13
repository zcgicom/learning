package com.itcat;

import java.util.Arrays;
import java.util.Comparator;

/**
 * JZ32-把数组排成最小的数
 * 题目描述:
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 * 说明：
 *      1.compareTo(referenceName) 方法用于将 Number 对象与方法的参数进行比较。可用于比较 Byte, Long, Integer等。
 *        该方法用于两个相同数据类型的比较，两个不同类型的数据不能用此方法来比较。
 *      2.参数：referenceName -- 可以是一个 Byte, Double, Integer, Float, Long 或 Short 类型的参数。
 *      3.返回值：
 *          如果指定的数与参数相等返回0。
 *          如果指定的数小于参数返回 -1。
 *          如果指定的数大于参数返回 1。
 *      4.Arrays.sort()的三种排序方法：
 *          (1)Arrays.sort(int[] a)     ##这种形式是对一个数组的所有元素进行排序，并且是按从小到大的顺序。
 *          (2)Arrays.sort(int[] a, int fromIndex, int toIndex)
 *          ##这种形式是对数组部分排序，也就是对数组a的下标从fromIndex到toIndex-1的元素排序，注意：下标为toIndex的元素不参与排序哦！
 *          (3)public static void sort(T[] a,int fromIndex,int toIndex, Comparator c)
 *          ##前两种排序有一个拘束，就是排列顺序只能是从小到大，如果我们要从大到小，就要使用这种方式。
 */
public class TestPrintMinNumber {
    public static void main(String[] args) {
        int[] tq = {3,32,321};
        System.out.println(pringMinNumber(tq));
        Arrays.sort(tq);
        for (int i: tq) {
            System.out.printf(i+" ");
        }
    }
    //把数组排成最小的数
    public static String pringMinNumber(int[] numbers){
        String [] str = new String[numbers.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        //排序
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String o1, String o2) {
                System.out.println("o1:"+o1+"o2:"+o2);//o1:32 o2:3  o1:321 o2:32
                return (o1 + o2).compareTo(o2 + o1);//返回负值表示从大到小排列(倒序)，返回正值表示从小到大排列(正序)
            }
        });
        String res = "";//拼接
        for (String s : str) {
            res += s + " ";
        }
        return res;
    }
}
