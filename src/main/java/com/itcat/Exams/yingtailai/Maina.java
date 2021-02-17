package com.itcat.Exams.yingtailai;

import java.util.ArrayList;
import java.util.Scanner;

public class Maina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<=col+row-2;i++){
            for(int x=0;  x<=i&&(x<row)&&i-x<col  ;x++){
                res.add(arr[x][i-x]);
            }
            for(int y=col-1;  y>=0&&i-y>=0&&i-y<row&&i-y>0  ;y--){
                res.add(arr[i-y][y]);
            }
        }
        for (int i = 0; i < res.size()-1; i++) {
            System.out.print(res.get(i)+",");
        }
        System.out.print(res.get(res.size()-1));
    }
}
