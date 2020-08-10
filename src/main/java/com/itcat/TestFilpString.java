package com.itcat;

/**
 * 翻转字符串
 */
public class TestFilpString {
    public static void main(String[] args) {
        String str = "student. a am I";
        System.out.println(flip(str));
    }
    public static String flip(String str){
        String[] strings = str.split(" ");
        String res = "";
        for (int i = strings.length-1; i >=0 ; i--) {
            if (i == 0) {
                res += strings[i];
            } else {
                res += strings[i] + " ";
            }
        }
        return res;
    }
}
