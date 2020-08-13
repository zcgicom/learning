package com.itcat;
import java.util.HashMap;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）。
 * （从0开始计数）
 *
 * str.indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。
 * @param searchvalue 必需。规定需检索的字符串值。该字符串可以是单个字符，也可以是一个字符串。
 * @param fromindex 可选的整数参数。规定在字符串中开始检索的位置。它的合法取值是 0 到 stringObject.length - 1。
 *                  如省略该参数，则将从字符串的首字符开始检索。
 * 注意：
 *      1.indexOf() 方法对大小写敏感！
 *      2.如果要检索的字符串值没有出现，则该方法返回 -1。
 */
public class TestFirstCharLocal {
    public static void main(String[] args) {
        String str = "aaaxxzyysx";
        System.out.println(FirstNotRepeatingChar(str));
        System.out.println(FirstNotRepeatingChar1(str));
        System.out.println(FirstNotRepeatingChar2(str));
    }
    //返回只出现一次字符的第一个位置
    public static int FirstNotRepeatingChar(String str) {
        if(str.equals("") || str.length() == 0) return -1;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!map.containsKey(ch)){
                //第一次出现赋值1
                map.put(ch,1);
            }else {
                //不是第一次出现+1
                map.put(ch,map.get(ch)+1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.get(ch) == 1) return i;
        }
        return -1;
    }
    //采用HashMap方法的时间复杂度和空间复杂度较高，建议采用下述两种方法遍历
    public static int FirstNotRepeatingChar1(String str) {
        if(str.equals("") || str.length() == 0) return -1;
        char[] ch=str.toCharArray();
        int pos = -1;
        int j = 0;
        for(int i=0;i<ch.length;i++){
            for(j=0;j<ch.length;j++){
                if((ch[i]==ch[j])&&(i!=j))break;
            }
            if(j == ch.length){
                pos = i;
                break;
            }
        }
        return pos;
    }
    //FirstNotRepeatingChar2与方法FirstNotRepeatingChar1复杂度相似
    public static int FirstNotRepeatingChar2(String str) {
        if(str.equals("") || str.length() == 0) return -1;
        for (int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i && str.indexOf(str.charAt(i),i+1) == -1) return i;
        }
        return -1;
    }
}
