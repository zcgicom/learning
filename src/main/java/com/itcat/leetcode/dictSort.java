package com.itcat.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class dictSort {
    public static void main(String[] args) {
        List<Integer> list = lexicalOrder(13);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println("==============");
        List<Integer> list1 = lexicalOrder1(13);
        Iterator<Integer> it1 = list.iterator();
        while (it1.hasNext()){
            System.out.print(it1.next()+" ");
        }
    }
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i < 10; i++){
            if(i<=n){
                list.add(i);
                add(list,n,i);
            }else{
                break;
            }
        }
        return list;
    }

    private static void add(List<Integer> list, int n, int startNum){
        startNum *= 10;
        for(int i = 0; i < 10; i++,startNum++){
            if(startNum<=n){
                list.add(startNum);
                add(list, n, startNum);
            }else{
                return;
            }
        }
    }

    public static List<Integer> lexicalOrder1(int n) {
        List<Integer> res = new ArrayList<Integer>();
        String[] strings = new String[n];
        for(int i=0;i < n;i++) strings[i]=String.valueOf(i+1);
        Arrays.sort(strings);
        for(String s:strings) res.add(Integer.parseInt(s));
        return res;
    }
}
