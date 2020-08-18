package com.itcat.Exams.qianxin;

import java.util.Scanner;

public class TestN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(CalulateMethodCount(target));
    }
    //
    public static int CalulateMethodCount(int target) {
        return target <= 1?1:CalulateMethodCount(target -1)<<1;
    }
}
