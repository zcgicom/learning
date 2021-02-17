package com.itcat.nowCoder;


import java.util.ArrayList;

/**
 * 求出一定范围内的所有丑数
 */
public class TestUgly {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(GetUglyNumber_Solution(10));
    }

    public static int GetUglyNumber_Solution(int n)
    {
        if(n==0)return 0;
        ArrayList<Integer> res=new ArrayList<Integer>();
        res.add(1);
        int i2=0,i3=0,i5=0;
        while(res.size()<n)
        {
            int m2=res.get(i2)*2;
            int m3=res.get(i3)*3;
            int m5=res.get(i5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            res.add(min);
            if(min==m2)i2++;
            if(min==m3)i3++;
            if(min==m5)i5++;
        }
        return res.get(res.size()-1);
    }
}
