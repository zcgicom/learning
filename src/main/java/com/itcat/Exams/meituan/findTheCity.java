package com.itcat.Exams.meituan;

import java.util.Arrays;

public class findTheCity {
    public static void main(String[] args) {
        int n =5;
        int dist = 1;
        int[][] arr = {{1,2,1},{2,3,1},{3,4,1},{4,5,1}};
//        int[][] arr = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int res = getTheCity(n,arr,dist);
        System.out.println(res);
    }
    //
    public static int getTheCity(int n, int[][] edges, int distanceThreshold) {
        final int N = 65536;
        int[][] dis = new int[n+1][n+1];
        // 使用一个大值，对距离数组进行填充（不能使用最大值，相加后会变成负数，导致比较出错）
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], N);
        }
        // 顶点到自身的距离为0
        for (int i = 0; i < dis.length; i++) {
            dis[i][i] = 0;
        }
        // 将顶点到其他点的距离，写入到距离数组中
        for (int[] path : edges) {
            dis[path[0]][path[1]] = path[2];
            dis[path[1]][path[0]] = path[2];
        }
        // Floyd算法
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        dis[i][j] = len;
                    }
                }
            }
        }
        // 找出长度小于distanceThreshold的路径个数最少且最大编号的顶点
        int res = n - 1;
        int minPath = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            // 统计当前城市长度小于distanceThreshold的路径个数
            for (int j = 0; j < n; j++) {
                if (dis[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt < minPath) {
                res = i;
                minPath = cnt;
            }
        }
        return res;
    }
}
