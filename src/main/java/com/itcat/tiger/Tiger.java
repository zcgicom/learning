package com.itcat.tiger;

import java.util.Scanner;

public class Tiger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入任务量x：");
        int x = sc.nextInt();//需要完成的任务量
        System.out.println("初始等级：");
        int level = sc.nextInt();//初始等级
        int[][] tasks = new int[x][2];
        System.out.println("输入要求和等级");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < 2; j++) {
                tasks[i][j] = sc.nextInt();//第i个任务最低等级和等级
//                tasks[i][j] = sc.nextInt();//第i个任务提升等级
            }
        }
        System.out.println(getLevel(tasks,level));
    }
    //练级
    public static int getLevel(int[][] task,int lev){
        int temp = lev;
        for (int i = 0; i < task.length; i++) {
            if(temp >= task[i][0]){
                temp += task[i][1];
            }
        }
        return temp;
    }
}
