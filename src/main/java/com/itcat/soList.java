package com.itcat;

public class soList {
    public static void main(String[] args) {
        String [] strs = {"a","bc","df","gh"};
        printCombination(strs);
    }
    public static void printCombination(String[] str){
        int totCnt = 1;
        int num = str.length;
        for (int i = 0; i < num; i++) {
            totCnt *= str[i].length();
        }
        int index = 0;
        String[] res = new String[totCnt];
        for (int i = 0; i < totCnt; i++) {
            int codeNow = i;
            String ss = "";
            boolean flag = false;
            for (int j = 0; j < num; j++) {
                int base = str[j].length();
                int bit = codeNow % base;
                codeNow /= base;
                char ch = str[j].charAt(bit);
                if (ss.contains(Character.toString(ch))){
                    flag = true;
                }
                ss += ch;
            }
            if (flag){
                res[index] = ss + "--circular dependency";
            }else {
                res[index] = ss;
            }
            index++;
        }
        for (String sr:res) {
            System.out.println(sr);
        }
    }
}
