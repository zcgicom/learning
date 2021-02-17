package com.itcat.Exams.qianxin;

import java.util.Arrays;

public class house {
    public static void main(String[] args) {
        int[] arr = {2,5,3,1,3};
        System.out.println(house(arr));
    }
    public static int house(int[] person){
        int[] tq = new int[person.length];
        Arrays.fill(tq,1);
        boolean t = true;
        while (t){
            t = false;
            for (int i = 0; i < person.length; i++) {
                if (i!=person.length - 1&&person[i]>person[i+1]&&tq[i]<=tq[i+1]){
                    tq[i] = tq[i+1] +1;
                    t = true;
                }
                if (i>0&&person[i]>person[i-1]&&tq[i]<=tq[i-1]){
                    tq[i]=tq[i-1]+1;
                    t = true;
                }
            }
        }
        int min = 0;
        for (int i = 0; i < tq.length; i++) {
            min += tq[i];
        }
        return min;
    }
}
