package com.itcat.test;

/**
 * 破译敌军密码:已知数字和小写字母之间存在联系，假如0代表a，25代表z，请给出该数字序列的不同组合
 * 输入：
 *      12158
 * 输出：
 *      bcbfi bcpi mbfi bvfi bcpi
 */
public class Maina {
    public static void main(String[] args) {
        String str = "12158";
        System.out.println(getii(str));
    }
    public static int getii(String str){
        if (str.length() < 1)return 1;
        char[] ch = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int count = 1;

        for (int i = 0; i < str.length(); i++) {

        }
        return 0;
    }
}
