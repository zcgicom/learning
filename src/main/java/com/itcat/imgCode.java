package com.itcat;

import java.util.Random;

/**
 * 密码生成器
 */
public class imgCode {
    public static void main(String[] args) {

        boolean res = getRandomPassword("123453ASs#");
        System.out.println(res);

        System.out.println(makeRandomPassword(8));//生成密码
        System.out.println(makeImgCode(4));//生成验证码
    }
    //验证密码格式
    public static boolean getRandomPassword(String password) {
        int len = password.length();
        while(len>=8){
            if (password.matches(".*[a-z]{1,}.*") && password.matches(".*[A-Z]{1,}.*") &&
                    password.matches(".*\\d{1,}.*") && password.matches(".*[~!@#$%^&*\\.?]{1,}.*")) {
                return true;
            }else return false;
        }
        return false;
    }
    //随机密码生成
    public static String makeRandomPassword(int len){
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*.?".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }

    //验证码生成器
    public static String makeImgCode(int len){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder pwd = new StringBuilder();
        for (int i = 0; i < len; i++) {
            pwd.append(str.charAt(random.nextInt(str.length())));
        }
        return pwd.toString();
    }
}
