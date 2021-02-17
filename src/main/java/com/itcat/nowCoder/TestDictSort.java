package com.itcat.nowCoder;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestDictSort {
    public static void sort(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("red");
        arr.add("8");
        arr.add("pink");
        arr.add("5");
        arr.add("black");
        arr.add("晨");
        arr.add("write");
        arr.add("张");
        arr.add("7");
        arr.add("purple");
        arr.add("哗哗");

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    String str1 = new String(o1.toString().getBytes("GB2312"),"ISO-8859-1");
                    String str2 = new String(o2.toString().getBytes("GB2312"),"ISO-8859-1");
                    return str1.compareTo(str2);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                return 0;
            }
        });
        for(int i = 0;i < arr.size();i++){
            System.out.println(arr.get(i));
        }
    }

    public static void main(String[] args) {
        sort();
    }
}
