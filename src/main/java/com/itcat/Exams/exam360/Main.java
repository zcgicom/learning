package com.itcat.Exams.exam360;

import java.util.Scanner;

/**
 * 输入：
 *      4 3
 *      1 2 1
 * 输出：
 *      2 1 4 3
 * 过程：
 *  {1,2,3,4} --> {2,3,4,1} --> {3,2,1,4} --> {2,1,4,3}
 *                 m = 1        m = 2          m = 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        int m = sc.nextInt();
        int[] list = new int[m];
        for (int i = 0; i < m; i++) {
            list[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        getLine(arr,list);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void getLine(int[] n_arr,int[] m_arr){
        if(n_arr.length == 0||n_arr == null)return;
        for (int i = 0; i < m_arr.length; i++) {
            if(m_arr[i] == 1){//m取1操作
                int temp = n_arr[0];
                int index = n_arr.length;
                for (int j = 1; j < index; j++) {
                    n_arr[j-1] = n_arr[j];
                }
                n_arr[index-1] = temp;
            }
            if (m_arr[i] == 2){//m取2操作
                int index = 0;
                while (index < n_arr.length){
                    int temp = n_arr[index];
                    n_arr[index] = n_arr[index+1];
                    n_arr[index+1] = temp;
                    index = index + 2;
                }
            }
        }
    }
}
