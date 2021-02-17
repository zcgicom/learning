package com.itcat.Exams.bianlifeng;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String query_model = sc.next();
        int count = sc.nextInt();
        String [][] arr = new String[count][2];
        for (int i = 0; i < count; i++) {
            String str = sc.next();
            arr[i][0] = str.split("->")[0];
            arr[i][1] = str.split("->")[1];
        }
        System.out.println(getNum(arr,query_model));
    }
    public static int getNum(String[][] arr,String query_model){
        int num = 0;
        if (arr.length == 0||arr[0].length == 0||arr[0][0] == arr[0][1]) return num;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (query_model.equals(arr[i][0])){

                for (int j = i+1; j < len; j++) {
                    if (!arr[j-1][0].equals(arr[j-1][1]) && arr[j-1][1].equals(arr[j][0])) num++;
                    else{
                        if (!arr[j-1][1].equals(arr[j][0])) num++;
                        break;
                    }
                }
//                if (!query_model.equals(arr[len-1][1])) num++;
                if (!query_model.equals(arr[len-1][1])) num--;
                break;
            }
        }
        return num;
    }
}
