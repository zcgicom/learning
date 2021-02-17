package com.itcat.Exams.jd;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 滚雪球求最大和
 */
public class Maina{
    public static int n;
    public static ArrayList<int[]> nums =  new ArrayList<int[]>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for (int i=0;i<n;i++){
            int[] temp = new int[2*(i+1)-1];
            String[] s = sc.nextLine().trim().split(" ");
            for (int j=0;j<2*(i+1)-1;j++){
                temp[j] = Integer.parseInt(s[j]);
            }
            nums.add(temp);
        }

        int res = choose(0,0);
        System.out.println(res);

    }

    public static int choose(int flow,int index){
        if (flow > n-1) return 0;
        int left_down = nums.get(flow)[index] + choose(flow+1,index);
        int down = nums.get(flow)[index] + choose(flow+1,index+1);
        int right_down = nums.get(flow)[index] + choose(flow+1,index+2);
        int max = left_down > down ? left_down : down;
        max = max > right_down ? max : right_down;
        return max;
    }
}