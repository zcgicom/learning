package com.itcat.Exams.BATTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 贪心算法 -- 使得U盘存储的文件个数最多
 */
public class maxSaveFilesNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入u盘容量M：");
        int M = sc.nextInt();//<1000000MB
        int n = sc.nextInt();//FilesNum
        int[] res = new int[n];
        System.out.println("输入N个元素(各元素之间用空格隔开)：");
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }
        System.out.println(getGreedy(res,M));
    }

    public static int getGreedy(int[] res,int m){
        int sum = 0;
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            if (m >= res[i]){
                sum++;
                m = m - res[i];
            }else break;
        }
        return sum;
    }
}
