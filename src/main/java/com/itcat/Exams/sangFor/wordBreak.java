package com.itcat.Exams.sangFor;

public class wordBreak {
    public static boolean wordBreak(String word,String[] strs){
        if (word.length() == 0||strs.length == 0) return false;
        int index = 0;
        int pos = 0;
        int len = strs.length;
        String s = "";
        for (int i = 0; i < len; i++) {
            pos += strs[i].length();
            s = word.substring(index,pos);
            if (!strs[i].equals(s)) return false;
            index = index + strs[i].length();
        }
        return true;
    }

    public static void main(String[] args) {
        String [] strs = {"code","sangfor","org"};
        System.out.println(wordBreak("codesangfororg",strs));
    }
}
