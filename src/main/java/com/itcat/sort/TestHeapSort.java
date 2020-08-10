package com.itcat.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 满足两个条件：
 *      1.树的本身属于完全二叉树
 *      2.树中父节点的值大于子节点的值
 *
 * parent = (i - 1)/2;
 * c1 = 2 * i + 1;
 * c2 = 2 * i + 2;
 */
public class TestHeapSort {
    public static void main(String[] args) {
        int[] tree = {4,10,3,5,1,2};//{10,5,3,4,1,2}
        heapSort(tree,0);
        System.out.println(Arrays.toString(tree));
    }
    //堆排序
    public static void heapSort(int[] tree,int i){
        int n = tree.length;//堆中包含的节点数
        if (i>=n){
            return;
        }
        int c1 = 2 * i + 1;//第一个子节点
        int c2 = 2 * i + 2;//第二个子节点
        int max = i;//父节点，默认第i个节点的值最大
        //找出父节点与子节点三者中对应数值最大的元素，将其放置在父节点的位置
        if(c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        if(max != i){
            swap(tree,max,i);
            heapSort(tree,max);//递归完成下一个堆的排序
        }
    }
    //交换
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
