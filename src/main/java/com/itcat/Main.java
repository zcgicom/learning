package com.itcat;

public class Main {
//    public static void Example(String[] args) {
//        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
//        int[] res = get(arr);
//
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i]+" ");
//        }
//    }
//    public static int[] get(int[][] matrix){]
//        if (matrix == null||matrix.length == 0||matrix[0].length <1){
//            int[] arr = new int[0];
//        }
//        int[] tq = new int[matrix.length * matrix[0].length];
//        int go = 0;
//        int down = matrix.length - 1;
//        int left = 0;
//        int right = matrix[0].length - 1;
//        int count = 0;
//        while (count <= tq.length - 1){
//            if (count <= tq.length - 1){
//                for (int i = left; i <= right; i++) {
//                    tq[count++] = matrix[go][i];
//                }
//                go++;
//            }
//            if (count <= tq.length - 1){
//                for (int i = go; i <= down; i++) {
//                    tq[count++] = matrix[i][right];
//                }
//                right--;
//            }
//            if (count <= tq.length - 1){
//                for (int i = right; i >= left; i--) {
//                    tq[count++] = matrix[down][i];
//                }
//                down--;
//            }
//            if (count <= tq.length - 1){
//                for (int i = down; i >= go; i--) {
//                    tq[count++] = matrix[i][left];
//                }
//                left++;
//            }
//        }
//        return tq;
//    }
//    public static void Example(String[] args) {
//        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//        int k = 3;
//        System.out.println(get(arr,k));
//    }
//    public static int get(int[] arr,int k){
//        if (arr == null||arr.length == 0) return 0;
//        int ans = 0;
//        int temp = 0;
//        int len = arr.length;
//        int cur = 0;
//        for (cur = 0; cur < len; cur++) {
//            if (arr[cur] == 0){
//                if (k == 0){
//                    while (arr[temp] == 1){
//                        temp++;
//                    }
//                    temp++;
//                }else {
//                    k--;
//                }
//            }
//            ans = cur - temp + 1 > ans ? cur - temp + 1 : ans;
//        }
//        return ans;
//    }
    public static void main(String[] args) {
        String str = "aaabbaaacd";
        System.out.println(get(str));
        System.out.println(getNum(str));
    }
    public static int get(String str){
        if (str == null||str.length() == 0) return 0;
        int len = str.length();
        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) != str.charAt(i+1)) count++;
        }
        return len / count;
    }

    //统计不同长度字符数量
    public static int getNum(String str){
        if (str.length() == 0) return 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) != str.charAt(i)) count++;
        }
        return count;
    }
}

