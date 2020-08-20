package com.itcat.Exams.yongyou;

import java.util.Arrays;

/**
 * 最便宜的价格列表
 */
public class minPrice {
    public static void main(String[] args) {
        int n = 3;
//        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src =0;
        int[] res = findCheapestPrice(n,edges,src);
            System.out.println(Arrays.toString(res));
    }
    public static int[] findCheapestPrice(int n,int[][] flight,int src){
        int[][] dist = new int[2][n];
        int[] s = new int[n];
        int inf = Integer.MAX_VALUE /2;
        Arrays.fill(dist[0],inf);
        Arrays.fill(dist[1],inf);
        dist[0][src] = dist[1][src] = 0;
        for (int i = 0; i < n; i++) {
            for (int[] edge:flight) {
                dist[i&1][edge[1]] = Math.min(dist[i&1][edge[1]],dist[~i&1][edge[0]] + edge[2]);
            }
        }

        for (int i = 0; i < dist[1].length; i++) {
//            System.out.println(Arrays.toString(dist[i]));
            if (dist[1][i] == inf){
                dist[1][i] = -1;
            }
        }
        return dist[1];
    }
}
