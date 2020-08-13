package com.itcat.bilibili;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 数组元素，加减乘除，得到24
 */
public class test1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.substring(1,str.length()-1).split(",");
        int t = strs.length;
//        List<Integer> list = new ArrayList<Integer>();
        int[] list = new int[t];
        for (int i = 0; i < t;i++) {
            list[i] = Integer.parseInt(strs[i]);
        }

        int[] list1 = {2,7,1,10};
            boolean flag = Game24Point(list1);
            System.out.println(flag);
    }

    public static boolean Game24Point(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            list.remove(i);
            if (getResult(list, temp)) {
                return true;
            }
            list.add(i, temp);
        }
        return false;
    }

    public static boolean getResult(List<Integer> list, int temp) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                list.remove(i);
                if (getResult(list, temp * n) || getResult(list, temp + n) || getResult(list, temp - n)) {
                    return true;
                } else if (temp % n == 0) {
                    if (getResult(list, temp / n)) {
                        return true;
                    }
                }
                list.add(i, n);
            }
            return false;
        } else {
            if (temp == 24) {
                return true;
            } else {
                return false;
            }
        }
    }
}

