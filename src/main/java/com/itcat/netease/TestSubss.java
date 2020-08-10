package com.itcat.netease;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 小易在维护数据的时候遇到一个需求，具体来说小易有一系列数据，这些数据了构成一个长度为n的数字序列，接下来小易会在这个序列上进行q次操作。
 * 每次操作有一个查询的数字x，小易需要将序列数据中所有大于等于x的数字都减一，并输出在本次操作中有多少个数字被减一了。
 * 小易犯了难，希望你能帮帮他。
 *
 * 输入描述:
 * 第一行n,q，表示数字个数和操作个数。
 * 接下来一行n个数表示初始的数字。
 * 接下来q行，每行一个数，表示指定的数字x。
 *
 * 输出描述:
 * 对于每个询问，输出一个数字表示答案
 */
public class TestSubss {
    public static void main(String[] args) {
        int[] tq = new int[2];
        System.out.println("请输入数字个数n和操作个数q(数字之间用空格隔开):");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < tq.length; i++) {
            tq[i] = sc.nextInt();
        }

        int[] res = new int[tq[0]];
        System.out.println("请输入n个数字(数字之间用空格隔开):");
        for (int i = 0; i < res.length; i++) {
            res[i] = sc.nextInt();
        }

        for (int i = 0; i < tq[1]; i++) {
            System.out.println("请输入请输入一个操作的数:");
            int in = sc.nextInt();
            int ans = count(res,in);
            System.out.println("本次操作中共有"+ans+"多少个数字被减一");
        }
    }

    public static int count(int[] nums, int tm){
        int count = 0;
        if(nums.length == 0) return count;
        Arrays.sort(nums);//排序后降低遍历次数
        for (int i = nums.length - 1; i >=0 ; i--) {
            if(tm<=nums[i]){
                nums[i] = nums[i] - 1;
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
