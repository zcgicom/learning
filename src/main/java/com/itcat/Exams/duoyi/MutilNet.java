package com.itcat.Exams.duoyi;

import java.util.Random;

/**
 * 多益网络 -等概率随机选出n个不等的数字
 * 思路：
 * 比如0到m-1这m个数字,从小到大放在一个数组里面,现在要选n个,我们只需要随机打乱这个数组,然后选取前n个元素就好.
 * 随机打乱的方法就是从数组头元素开始,每次产生一个随机数i然后交换这两个数,而且只需要交换n次就够了。
 * 因为我们并不取下标超过n后面的数字
 */
public class MutilNet {
    public static void randSelect(int[] nums, int n) {//随机选择
        Random rand = new Random();
        for(int i = 0; i < n; i ++){
            swap(nums , i, rand.nextInt(nums.length-i)+i);
        }
    }
    public static void swap(int[] nums, int m , int n){//交换
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
    public static void main(String[] args) {//主函数
        int[] nums = new int[100];//m=100
        for(int i = 0;i < 100;i++){
            nums[i]=i;
        }
        randSelect(nums,10);//n=10
        for(int i = 0;i < 10; i ++){
            System.out.print(nums[i]+"\t");
        }
    }
}
