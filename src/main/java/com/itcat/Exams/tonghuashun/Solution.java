package com.itcat.Exams.tonghuashun;
import java.lang.ref.SoftReference;

public class Solution {
    String str = new String("good");
    char[] ch={'a','b','c'};

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.change(solution.str,solution.ch);
//        System.out.println(solution.str+" and");
//        System.out.println(solution.ch);
        int count = 100000;
        SoftReference[] values = new SoftReference[count];
        for (int i = 0; i < count; i++) {
            values[i] = new SoftReference<Bigger>(new Bigger("Bigger-"+i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(((Bigger)(values[i].get())).name);
        }
    }
    public void change(String str,char[] ch){
        str="test ok";
        ch[0]='g';
    }
    public static class Bigger{
        public int[] values;
        public String name;

        public Bigger(String name) {
            this.name = name;
            values = new int[1024];
        }
    }
}
