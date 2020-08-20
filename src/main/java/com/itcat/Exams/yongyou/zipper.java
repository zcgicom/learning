package com.itcat.Exams.yongyou;

import java.util.Scanner;

/**
 * 题目描述
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
 * 若压缩后的字符串没有变短，则返回原先的字符串。
 */
public class zipper {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str =in.next();
        System.out.println(StringDo(str));
    }
    public static Object StringDo(String str) {
        int flog=1;
        StringBuffer str2=new StringBuffer();//

        if(str.length()<=2) {
            return str;//输入的str长度小于等于2，一定返回原字符串；
        }

        for(int i =1;i<str.length();i++) {

            if(str.charAt(i-1)==str.charAt(i)) {
                flog++;//记录字符出现次数
            }else {
                str2.append(str.charAt(i-1)).append(flog);
                flog=1;//将字符和出现次数写入；
            }
        }

        str2.append(str.charAt(str.length()-1)).append(flog);//最后一个字符要自己额外写入，原因略；

        if(str.length()<=str2.length()) {
            return str;
        }else{
            return str2;
        }

    }
}

