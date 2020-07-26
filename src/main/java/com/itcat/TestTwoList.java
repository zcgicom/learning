package com.itcat;

/**
 * 遍历二维数组 -- 二分查找或遍历
 */
public class TestTwoList {
    public static void main(String[] args) {
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean temp = Find2(array,7);
        System.out.println(temp);
    }
    //二分查找
    public static Boolean Find1(int [][] array,int target){
        for (int i = 0; i < array.length; i++) {
            int low =0;
            int high =array[i].length - 1;
            for (int j = 0; j < array[i].length; j++) {
                if(low>high){
                    return false;
                }
                int mid = (low+high) >> 2;
                if(target>array[i][mid]){
                    low = mid + 1;
                }else if(target<array[i][mid]){
                    high = mid - 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
    //遍历
    public static boolean Find2(int [][] array,int target) {
        int row = 0;
        int column = array[0].length - 1;
        while(row < array.length && column >= 0){
            int val = array[row][column];
            if(target > val){
                row++;
            }else if(target < val){
                column--;
            }else{
                return true;
            }
        }
        return false;
    }
}
