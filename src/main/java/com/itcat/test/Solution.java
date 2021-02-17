package com.itcat.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void help(int idx,char[] s,ArrayList<String> r){

        if(idx==s.length-1){
            r.add(new String(s));
            return;
        }

        char t=s[idx];
        boolean doit=true;//是否为新
        for(int i=idx;i<s.length;i++){
            doit=true;
            for(int j=idx;j<i;j++){//在[idx]上待过的字符为s[idx]~s[i-1]   重点！！！
                if(s[j]==s[i]){
                    doit=false;break;//去重
                }
            }
            if(!doit)continue;
            s[idx]=s[i];
            s[i]=t;
            help(idx+1,s,r);
            s[i]=s[idx];
            s[idx]=t;
        }
    }

    public static String[] permutation(String s) {
        ArrayList<String> r=new ArrayList<String>(s.length()*s.length());//预分配省1ms
        help(0,s.toCharArray(),r);
        return (String [])r.toArray(new String[r.size()]);
    }

    public static void main(String[] args) {
        String [] res = permutation("abc");
        for (String str:res) {
            System.out.println(str);
        }
    }
}

class Solution1 {
    List<String> res = new LinkedList<String>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<Character>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        Solution1 sl = new Solution1();
        String[] arr = sl.permutation("abc");
        for (String str:arr) {
            System.out.println(str);
        }
    }
}