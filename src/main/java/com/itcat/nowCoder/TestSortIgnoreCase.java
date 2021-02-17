package com.itcat.nowCoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 不区分大小写的升序排序List
 **/
public class TestSortIgnoreCase {
    public static void main(String[] args) {
        List<String> unsort = new ArrayList<String>();
        for (String s : new String[]{"Algebra", "History", "Geometry", "english"}) {
            unsort.add(s);
        }
        System.out.println(sort(unsort));

    }
    public static List<String> sort(List<String> textbooks) {
        Collections.sort(textbooks, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return s1.toUpperCase().compareTo(s2.toUpperCase());
            }
        });
        return textbooks;
    }
        //自定义比较类
    /*static class SortCaseNoSensitive implements Comparator<String>{
        public int compare(String s1, String s2) {
            return s1.toUpperCase().compareTo(s2.toUpperCase());
        }
    }*/
}
