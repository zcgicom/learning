package com.itcat.Exams.sougou;

public class mx {
    public static void main(String[] args) {
        int[] arr = {-1,4,5,2};
        System.out.println(getHouses(2,arr));
    }
    public static int getHouses (int t, int[] xa) {
        // write code here
        if(xa.length == 0||xa == null) return 0;
        int pre_a = xa[0] - xa[1]/2;
        int pre_b = xa[0] + xa[1]/2;
        int pos_a = xa[2] - xa[3]/2;
        int pos_b = xa[2] + xa[3]/2;
        int count = 0;
        if ((pos_a - pre_b) == 2)count++;
        if ((pos_a - pre_b) > 2) count = count + (pos_a - pre_b)/2 +1;
        return count+2;
    }
}
