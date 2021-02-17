package com.itcat.nowCoder;

import java.util.HashMap;

/**
 * 打印第一个不重复的字符
 * //采用char方式 或 HashMap的方式
 */
public class TestPrintFirstChar {
    public static void main(String[] args) {
        int[] table = new int[256];
        StringBuffer s = new StringBuffer();
        Insert('s',table,s);
        Insert('x',table,s);
        Insert('s',table,s);
        char sf = FirstAppearingOnce(table,s);
        System.out.println("s:"+s);
        System.out.println(sf);
        System.out.println(Integer.valueOf('x'));
        //HashMap
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        InsertHash('s',map);
        InsertHash('x',map);
        InsertHash('s',map);
        InsertHash('a',map);
        char df = FirstSingleValue(map);
        System.out.println("hashmap获得第一个出现一次的字符为:"+df);
        for (String key : map.keySet()) {
            System.out.println(key+"字符在字符流中共出现过："+map.get(key)+"次！");
        }
    }

        //Insert one char from stringstream
        public static void Insert(char ch,int[] table,StringBuffer s) {
            s.append(ch);
//            System.out.println(ch);
            table[ch] += 1;//输入的字符ch作为table的索引
//            System.out.println(table[ch]);
        }
        //return the first appearence once char in current stringstream
        public static char FirstAppearingOnce(int[] table,StringBuffer s) {
            char[] str = s.toString().toCharArray();
            for (char c : str) {
                if (table[c] == 1)
                    return c;
            }
            return '#';
        }
        //HashMap
        public static char FirstSingleValue(HashMap<String,Integer> map){
            for (String key : map.keySet()) {
                if(map.get(key) == 1){
                    char[] str = key.toCharArray();
                    return str[0];
                }
            }
            return '#';
        }

        public static void InsertHash(char ch,HashMap<String,Integer> map){
            String s = "" + ch;
            if(!map.containsKey(s)){
                map.put(s,1);
            }else {
                map.put(s,map.get(s)+1);
            }
        }
}
