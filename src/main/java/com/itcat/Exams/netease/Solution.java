package com.itcat.Exams.netease;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int lengthOfSubstring(String s) {
        int n = s.length(), ans = 0;
        char [] ch = {'a','b','c','x','y','z'};
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
        for (int j = 0, i = 0; j < n; j++) {
            boolean flag = isTure(s.charAt(j),ch);
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
            if (flag&&j%2 != 0)return ans;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfSubstring("amabc"));
    }
    public static boolean isTure(char ch,char[] arr){
        int len =arr.length;
        for (int i = 0; i < len; i++) {
            if(ch == arr[i]) return true;
        }
        return false;
    }
}
