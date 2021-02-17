package com.itcat.Exams.netease;

import java.util.Scanner;

public class subStr {
    public static int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans - n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(countSubstrings(sc.nextLine()));
    }
}
