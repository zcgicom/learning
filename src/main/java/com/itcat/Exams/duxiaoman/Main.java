package com.itcat.Exams.duxiaoman;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 能图多少色块
 */
public class Main {
    public static int sum(String str1,String str2){
        if(str1.length() == 0||str2.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (map.containsKey(str2.charAt(i))) map.put(str2.charAt(i),map.get(str2.charAt(i))+1);
            else map.put(str2.charAt(i),1);
        }
        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i))&&map.get(str1.charAt(i))>0){
                count++;
                map.put(str1.charAt(i),map.get(str1.charAt(i))-1);
            }
        }
//        for (Character ch :map.keySet()) {
//            System.out.print(ch+" "+map.get(ch));
//        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(sum(str1,str2));
    }
}
