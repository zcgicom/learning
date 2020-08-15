package com.itcat.Exams.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 提取字符串的每个单词首字母
 *
 * 输入描述：
 *      looks good to me
 *
 * 输出描述：
 *      lgtm
 */
public class TestStringAcronym {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入一个字符串(单词之间用空格隔开)：");
        String str = br.readLine();
        System.out.println(getStringAcronym(str));
    }

    public static String getStringAcronym(String str){
        StringBuilder sb = new StringBuilder();
        while (str != null){
            String[] tq = str.split(" ");
            for (String in : tq) {
                sb.append(in.charAt(0));
            }
            return sb.toString();
        }
        return sb.toString();
    }
}
