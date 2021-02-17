package com.itcat.Exams.sougou;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回生成的新密码个数
     * @param password string字符串 密码的数组字符串（长度小于50），例如 12345
     * @return long长整型
     */
    public static long getPasswordCount (String password) {
        // write code here
        if(password == null||password.length() == 0) return (long)0;
        long sum = 0;
        String tq = "";
        String tq1 = "";
        int cc = 0;
        int len = password.length();
        for(int i = 0;i<=9;i++){
            tq = tq + i;
            cc = i;
            for(int j=1;j<len;j++){
//                System.out.print((password.charAt(j) - '0'));
                if((cc+(password.charAt(j) - '0'))%2 == 0){
                    cc = (cc+(password.charAt(j) - '0'))/2;
                    tq += cc;
                    sum++;
                    if(password.equals(tq)) sum--;
                }else{
                    tq1 = tq;
                    tq += (cc+(password.charAt(j) - '0'))/2;
                    tq1 += ((cc+(password.charAt(j) - '0'))/2 + 1);
                    sum = sum+2;
                    if(password.equals(tq)) sum--;
                    if(password.equals(tq1)) sum--;

                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getPasswordCount("123"));
    }
}
