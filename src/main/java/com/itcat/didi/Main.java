package com.itcat.didi;

import java.util.Scanner;

/**
 * 将字符串按长度n分组并反转组成字符串
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int n = sc.nextInt();//Gogo, go out!?
        String str = sc.next();
        System.out.println(getPwd(n,str));
    }
    public static String getPwd(int n,String str){
        if (str.length() == 0||str == null)return "";
        int pre = 0;
        int pos = n;
        String res = "";
        int m = str.length()/n;
        for (int i = 0; i < m; i++) {
            for (int j = n-1; j >=0; j--) {
                res += Character.toString(str.substring(pre,pos).charAt(j));
            }
            System.out.println("xxx："+res);
            pre += n;
            pos += n;
        }
        if (str.length()%n != 0){
            for (int i = str.length() - n*m - 1; i >=0 ; i--) {
                res += Character.toString(str.substring(n*m).charAt(i));
            }
        }
        return res;
    }
}
